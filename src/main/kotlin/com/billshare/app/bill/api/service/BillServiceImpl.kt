package com.billshare.app.bill.api.service

import com.billshare.app.access.user.domain.User
import com.billshare.app.bill.domain.Bill
import com.billshare.app.bill.domain.BillRepository
import com.billshare.app.bill.domain.UserBill
import org.hibernate.SessionFactory
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BillServiceImpl(val billRepository: BillRepository, val sessionFactory: SessionFactory): BillService {

    @Transactional
    override fun addUser(billId: Long, userId: Long, userBill: UserBill) {
        val currentSession = sessionFactory.currentSession
        val bill = currentSession.load(Bill::class.javaObjectType, billId)
        val user = currentSession.load(User::class.javaObjectType, userId)
        userBill.user = user
        userBill.bill = bill
        userBill.userBillId?.userId = user.id
        userBill.userBillId?.billId = bill.id
        bill.users = bill.users.plus(userBill)
        currentSession.transaction.begin()
        billRepository.save(bill)
        currentSession.transaction.commit()
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