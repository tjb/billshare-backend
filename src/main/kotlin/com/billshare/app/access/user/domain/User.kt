package com.billshare.app.access.user.domain

import com.billshare.app.access.user.view.models.UserView
import com.billshare.app.bill.domain.Bill
import com.fasterxml.jackson.annotation.JsonView
import javax.persistence.*


@Entity
@Table(name = "Users")
data class User (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @JsonView(UserView.UserSummary::class)
        val id: Long? = null,

        @Column(name = "email", nullable = false)
        @JsonView(UserView.UserSummary::class)
        val email: String = "",

        @Column(name = "password", nullable = false)
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

        @OneToMany(mappedBy = "user")
        val bills: List<Bill> = emptyList()

)
//{
//        override fun toString(): String {
//                return "Bill [id = " + id +
//                        ", email = " + email +
//                        ", first = " + first +
//                        ", last = " + last +
//                        ", enabled = " + enabled
//        }
//}

// Extension functions
fun User.toCurrentUser(): CurrentUser {
  return CurrentUser(id = id, first = first, last = last, email = email, password = password, enabled = enabled)
}