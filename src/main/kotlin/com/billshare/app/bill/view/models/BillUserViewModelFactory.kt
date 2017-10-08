package com.billshare.app.bill.view.models

import com.billshare.app.Factory
import com.billshare.app.bill.domain.UserBill
import org.springframework.stereotype.Service

@Service
class BillUserViewModelFactory : Factory<UserBill, Void, BillUserViewModel> {
    override fun create(source1: UserBill?, source2: Void?): BillUserViewModel {
        if (source1 == null)
            throw IllegalArgumentException()
        return BillUserViewModel(id = source1.user?.id,
                first = source1.user?.first,
                last = source1.user?.last)
    }
}