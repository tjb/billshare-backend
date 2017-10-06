package com.billshare.app.bill.api.controller

import com.billshare.app.IFactory
import com.billshare.app.access.user.domain.CurrentUser
import com.billshare.app.access.user.domain.User
import com.billshare.app.access.user.domain.UserView
import com.billshare.app.bill.api.service.BillService
import com.billshare.app.bill.domain.Bill
import com.billshare.app.bill.domain.BillView
import com.fasterxml.jackson.annotation.JsonView
import javassist.tools.web.BadHttpRequest
import org.springframework.web.bind.annotation.*
import org.springframework.security.core.context.SecurityContextHolder



@RestController
@RequestMapping(value = "/bills")
class BillsController(val billService: BillService, var userFactory: IFactory<CurrentUser, Void, User>) {

  @GetMapping(value = "/{id}")
  @JsonView(BillView.ExtendedBillSummary::class)
  fun findById(@PathVariable id: Long): Bill {
      return billService.findById(id)
  }

  @DeleteMapping(value = "/{id}")
  fun delete(@PathVariable id: Long) {
    billService.delete(id)
  }

  @PostMapping
  @JsonView(BillView.BillSummary::class)
  fun create(@RequestBody bill: Bill): Bill {
    val auth = SecurityContextHolder.getContext().authentication
    bill.user = userFactory.create(auth.principal as CurrentUser, null)
    return billService.save(bill)
  }

  @PutMapping(value= "/{id}")
  @JsonView(BillView.BillSummary::class)
  fun update(@PathVariable id: Long, @RequestBody bill: Bill): Bill {
    if(id != bill.id)
      throw BadHttpRequest();
    return billService.save(bill)
  }
}