package com.billshare.app.percentage.domain

import com.billshare.app.access.user.domain.User
import com.billshare.app.bill.domain.Bill
import javax.persistence.*

@Entity
@Table(name = "percentage")
data class Percentage (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        val id: Long? = null,

        @Column(name = "percentage")
        val percentage: Double? = null,

        @ManyToOne
        @JoinColumn(name = "bill_id", referencedColumnName = "id")
        val bill: Bill? = null,

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        val user: User? = null
)