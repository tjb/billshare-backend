package com.billshare.app.bill.view.models

import com.billshare.app.Factory
import com.billshare.app.bill.domain.Bill
import org.springframework.stereotype.Service

@Service
class BillViewModelFactory: Factory<Bill, Void, BillViewModel> {
    override fun create(source1: Bill?, source2: Void?): BillViewModel {
        if(source1 == null)
            throw IllegalArgumentException()
        return BillViewModel(id = source1.id,
                dueDate = source1.dueDate,
                name = source1.name,
                price = source1.price)
    }
}