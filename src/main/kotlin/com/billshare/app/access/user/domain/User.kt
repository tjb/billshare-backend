package com.billshare.app.access.user.domain

import com.billshare.app.bill.domain.Bill
import javax.persistence.*

@Entity
@Table(name = "user")
data class User (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        val id: Long? = null,

        @Column(name = "first")
        val first: String? = null,

        @Column(name = "last")
        val last: String? = null,

        @OneToMany
        @JoinColumn(name = "bill_id", referencedColumnName = "id")
        val bills: List<Bill> = ArrayList<Bill>()

)