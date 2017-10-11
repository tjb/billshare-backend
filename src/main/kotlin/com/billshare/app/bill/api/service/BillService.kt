package com.billshare.app.bill.api.service

import com.billshare.app.bill.domain.Bill
import com.billshare.app.bill.domain.UserBill

interface BillService {

  fun findById(id: Long): Bill

  fun save(bill: Bill): Bill

  fun delete(id: Long)

  fun addUser(userBill: Long, userId: Long, userBill1: UserBill)
}