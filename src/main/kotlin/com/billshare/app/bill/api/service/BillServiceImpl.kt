package com.billshare.app.bill.api.service

import com.billshare.app.bill.domain.Bill
import com.billshare.app.bill.domain.BillRepository
import com.billshare.app.bill.domain.UserBill
import com.billshare.app.bill.domain.UserBillRepository
import org.springframework.stereotype.Service

@Service
class BillServiceImpl(val billRepository: BillRepository, val userBillRepository: UserBillRepository): BillService {

    override fun addUser(billId: Long, userId: Long, userBill: UserBill) {
        userBill.userBillId?.userId = userId
        userBill.userBillId?.billId = billId
        userBillRepository.save(userBill)
    }

    override fun save(bill: Bill): Bill {
    return billRepository.save(bill)
  }

  override fun delete(id: Long) {
      billRepository.delete(id)
  }

  override fun findById(id: Long): Bill {
      return billRepository.findOne(id)
  }
}