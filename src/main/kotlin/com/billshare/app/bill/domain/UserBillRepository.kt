package com.billshare.app.bill.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserBillRepository : JpaRepository<UserBill, UserBillId> {
}