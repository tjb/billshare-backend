package com.billshare.app.bill.domain

import com.billshare.app.access.user.domain.User
import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "UserBills")
data class UserBill(
        @Column(name = "amount")
        val amount: Double? = null,

        @Column(name = "amountType")
        val amountType: Long? = null,

        @Id
        @ManyToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        @JoinColumn(name = "userId")
        var user: User? = null,

        @Id
        @ManyToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
        @JoinColumn(name = "billId")
        var bill: Bill? = null
): Serializable{
        override fun toString(): String {
                return ""
        }
}

