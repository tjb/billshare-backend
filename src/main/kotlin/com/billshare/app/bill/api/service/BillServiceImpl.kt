package com.billshare.app.bill.api.service

import com.billshare.app.bill.domain.Bill
import com.billshare.app.bill.domain.BillRepository
import org.springframework.stereotype.Service

@Service
class BillServiceImpl(val billRepository: BillRepository): BillService {
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