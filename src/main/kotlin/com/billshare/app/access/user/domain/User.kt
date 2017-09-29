package com.billshare.app.access.user.domain

import com.billshare.app.bill.domain.Bill
import com.fasterxml.jackson.annotation.JsonView
import javax.persistence.*
import java.util.ArrayList

@Entity
@Table(name = "user")
data class User (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @JsonView(UserView.UserSummary::class)
        val id: Long? = null,

        @Column(name = "email", nullable = false)
        @JsonView(UserView.UserSummary::class)
        val email: String = "",

        @Column(name = "password", nullable = false)
        @JsonView(UserView.UserSummary::class)
        val password: String = "",

        @Column(name = "first")
        @JsonView(UserView.UserSummary::class)
        val first: String = "",

        @Column(name = "last")
        @JsonView(UserView.UserSummary::class)
        val last: String = "",

        @Column(name = "enabled", nullable = false)
        @JsonView(UserView.UserSummary::class)
        val enabled: Boolean = false,

        @OneToMany
        @JoinTable(name = "user_bill",
                joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "bill_id", referencedColumnName = "id")))
        @JsonView(UserView.ExtendedUserSummary::class)
        val bills: List<Bill> = ArrayList()

)

// Extension functions
fun User.toCurrentUser(): CurrentUser {
  return CurrentUser(id = id, first = first, last = last, email = email, password = password, enabled = enabled);
}