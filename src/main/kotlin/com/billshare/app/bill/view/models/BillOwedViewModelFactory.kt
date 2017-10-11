package com.billshare.app.bill.view.models

import com.billshare.app.Factory
import com.billshare.app.bill.domain.UserBill
import org.springframework.stereotype.Service

@Service
class BillOwedViewModelFactory: Factory<UserBill, Void, BillOwedViewModel> {
    override fun create(source1: UserBill?, source2: Void?): BillOwedViewModel {
        if (source1 == null)
            throw IllegalArgumentException()
        return BillOwedViewModel(id = source1.bill?.id,
                name = source1.bill?.name,
                dueDate = source1.bill?.dueDate,
                amount = source1.amount,
                amountType = source1.amountType,
                billTotal = source1.bill?.price)
    }
}