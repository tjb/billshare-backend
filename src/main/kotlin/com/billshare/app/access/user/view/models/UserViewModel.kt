package com.billshare.app.access.user.view.models

import com.billshare.app.bill.view.models.BillViewModel
import com.billshare.app.bill.view.models.BillOwedViewModel
import com.fasterxml.jackson.annotation.JsonView

data class UserViewModel(
        @JsonView(UserView.UserSummary::class)
        val id: Long? = null,

        @JsonView(UserView.UserSummary::class)
        val email: String = "",

        @JsonView(UserView.UserSummary::class)
        val first: String = "",

        @JsonView(UserView.UserSummary::class)
        val last: String = "",

        @JsonView(UserView.ExtendedUserSummary::class)
        val bills: List<BillViewModel>? = null,

        @JsonView(UserView.ExtendedUserSummary::class)
        val billsOwed: List<BillOwedViewModel>? = null
)