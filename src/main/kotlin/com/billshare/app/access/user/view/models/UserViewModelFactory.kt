package com.billshare.app.access.user.view.models

import com.billshare.app.Factory
import com.billshare.app.access.user.domain.User
import com.billshare.app.bill.domain.Bill
import com.billshare.app.bill.domain.UserBill
import com.billshare.app.bill.view.models.BillOwedViewModel
import com.billshare.app.bill.view.models.BillViewModel
import org.springframework.stereotype.Service

@Service
class UserViewModelFactory(val billViewModelFactory : Factory<Bill, Void, BillViewModel>, val billOwedViewModelFactory : Factory<UserBill, Void, BillOwedViewModel>) : Factory<User, Void, UserViewModel> {
    override fun create(source1: User?, source2: Void?): UserViewModel {
        if(source1 == null)
            throw IllegalArgumentException()
        return UserViewModel(id = source1.id,
                email = source1.email,
                first = source1.first,
                last = source1.last,
                bills = source1.bills.map { bill -> billViewModelFactory.create(bill, null) },
                billsOwed = source1.billsOwed.map { bill -> billOwedViewModelFactory.create(bill, null) })
    }
}