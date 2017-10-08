package com.billshare.app.bill.api.service

import com.billshare.app.bill.domain.Bill

interface BillService {

  fun findById(id: Long): Bill

  fun save(user: Bill): Bill

  fun delete(id: Long)

}