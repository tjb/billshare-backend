package com.billshare.app.access.user.domain

import com.billshare.app.bill.domain.Bill
import com.fasterxml.jackson.annotation.JsonView
import javax.persistence.*

@Entity
@Table(name = "user")
data class User (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @JsonView(UserView.UserSummary::class)
        val id: Long? = null,

        @Column(name = "first")
        @JsonView(UserView.UserSummary::class)
        val first: String? = null,

        @Column(name = "last")
        @JsonView(UserView.UserSummary::class)
        val last: String? = null,

        @OneToMany
        @JoinTable(name = "user_bill",
                joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "bill_id", referencedColumnName = "id")))
        @JsonView(UserView.ExtendedUserSummary::class)
        val bills: List<Bill> = ArrayList<Bill>()

)