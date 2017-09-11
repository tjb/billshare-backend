package com.billshare.app.access.user.domain

import com.billshare.app.bill.domain.BillView
import com.billshare.app.percentage.domain.PercentageView

class UserView {

    interface UserSummary {}

    interface ExtendedUserSummary: UserSummary, BillView.ExtendedBillSummary,
            PercentageView.PercentageSummary {}
}