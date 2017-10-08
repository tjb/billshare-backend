package com.billshare.app.bill.api.controller

import com.billshare.app.Factory
import com.billshare.app.access.user.domain.CurrentUser
import com.billshare.app.access.user.domain.User
import com.billshare.app.bill.api.service.BillService
import com.billshare.app.bill.domain.Bill
import com.billshare.app.bill.domain.UserBill
import com.billshare.app.bill.view.models.BillView
import com.billshare.app.bill.view.models.BillViewModel
import com.fasterxml.jackson.annotation.JsonView
import javassist.tools.web.BadHttpRequest
import org.springframework.web.bind.annotation.*
import org.springframework.security.core.context.SecurityContextHolder



@RestController
@RequestMapping(value = "/bills")
class BillsController(val billService: BillService, var userFactory: Factory<CurrentUser, Void, User>, var billViewModelFactory: Factory<Bill, Void, BillViewModel>) {

  @GetMapping(value = "/{id}")
  @JsonView(BillView.ExtendedBillSummary::class)
  fun findById(@PathVariable id: Long): BillViewModel {
    val bill = billService.findById(id)
    return billViewModelFactory.create(bill, null)
  }

  @DeleteMapping(value = "/{id}")
  fun delete(@PathVariable id: Long) {
    billService.delete(id)
  }

  @PostMapping
  @JsonView(BillView.BillSummary::class)
  fun create(@RequestBody bill: Bill): BillViewModel {
    val auth = SecurityContextHolder.getContext().authentication
    bill.user = userFactory.create(auth.principal as CurrentUser, null)
    val savedBill = billService.save(bill)
    return billViewModelFactory.create(savedBill, null)
  }

  @PutMapping(value= "/{id}")
  @JsonView(BillView.BillSummary::class)
  fun update(@PathVariable id: Long, @RequestBody bill: Bill): BillViewModel {
    if(id != bill.id)
      throw BadHttpRequest();
    val savedBill = billService.save(bill)
    return billViewModelFactory.create(savedBill, null)
  }

  @PostMapping(value= "/{id}/users/{userId}")
  @JsonView(BillView.BillSummary::class)
  fun addUser(@PathVariable id: Long, @PathVariable userId: Long, @RequestBody userBill: UserBill) {
    billService.addUser(id, userId, userBill)
  }
}