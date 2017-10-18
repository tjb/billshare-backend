package com.billshare.app.bill.view.models

import com.fasterxml.jackson.annotation.JsonView
import java.util.*

data class BillOwedViewModel(
        @JsonView(BillView.BillSummary::class)
        val id: Long? = null,

        @JsonView(BillView.BillSummary::class)
        val amount: Double? = null,

        @JsonView(BillView.BillSummary::class)
        val name: String? = null,

        @JsonView(BillView.BillSummary::class)
        val dueDate: Date? = null,

        @JsonView(BillView.BillSummary::class)
        val billTotal: Double? = null
        )