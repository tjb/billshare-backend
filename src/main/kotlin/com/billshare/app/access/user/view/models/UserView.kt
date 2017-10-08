package com.billshare.app.access.user.view.models

import com.billshare.app.bill.view.models.BillView

class UserView {

    interface UserSummary {}

    interface ExtendedUserSummary: UserSummary, BillView.ExtendedBillSummary {}
}