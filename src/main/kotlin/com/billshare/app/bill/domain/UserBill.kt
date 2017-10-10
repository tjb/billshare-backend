package com.billshare.app.bill.domain

import com.billshare.app.access.user.domain.User
import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "UserBills")
class UserBill {

        @EmbeddedId()
        var userBillId: UserBillId? = UserBillId()

        @Column(name = "amount")
        var amount: Double? = null

        @Column(name = "amountType")
        @Enumerated(EnumType.ORDINAL)
        var amountType: BillType? = null

        @ManyToOne
        @JoinColumn(name = "userId", updatable = false, insertable = false)
        var user: User? = null

        @ManyToOne
        @JoinColumn(name = "billId", updatable = false, insertable = false)
        var bill: Bill? = null

        constructor() {}

        constructor(user: User?, bill: Bill?, amount: Double?, amountType: BillType) {
                this.user = user
                this.bill = bill
                this.amount = amount
                this.amountType = amountType
                this.userBillId = UserBillId(user,  bill)
        }


        override fun toString(): String {
                        return ""
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as UserBill

                if (userBillId == null || userBillId!! != other.userBillId) return false

                return true
        }

        override fun hashCode(): Int {
                return userBillId?.hashCode() ?: 0
        }


}


@Embeddable
class UserBillId : Serializable {
        @Column(name = "billId")
        var billId: Long? = null

        @Column(name = "userId")
        var userId: Long? = null

        constructor() {}

        constructor(user: User?, bill: Bill?) {
                this.billId = bill?.id
                this.userId = user?.id
        }

        override fun hashCode(): Int {
                val prime = 31
                var result = 1
                result = prime * result + if (billId == null) 0 else billId!!.hashCode()
                result = prime * result + if (userId == null) 0 else userId!!.hashCode()
                return result
        }

        override fun equals(obj: Any?): Boolean {
                if (this === obj)
                        return true
                if (obj == null)
                        return false
                if (javaClass != obj.javaClass)
                        return false

                val other = obj as UserBillId?

                if (billId == null) {
                        if (other!!.billId != null)
                                return false
                } else if (billId!! != other!!.billId)
                        return false

                if (userId == null) {
                        if (other!!.userId != null)
                                return false
                } else if (userId!! != other!!.userId)
                        return false

                return true
        }
}