package com.billshare.app.bill.view.models

import com.fasterxml.jackson.annotation.JsonView

data class BillUserViewModel(
        @JsonView(BillView.BillSummary::class)
        val id: Long? = null,

        @JsonView(BillView.BillSummary::class)
        val first: String? = null,

        @JsonView(BillView.BillSummary::class)
        val last: String? = null
        )