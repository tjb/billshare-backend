package com.billshare.app.access.user.domain

import com.billshare.app.bill.domain.Bill
import com.fasterxml.jackson.annotation.JsonView
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*
import org.springframework.security.core.GrantedAuthority
import java.util.ArrayList

@Entity
@Table(name = "user")
data class User (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        @JsonView(UserView.UserSummary::class)
        private val id: Long? = null,

        @Column(name = "email", nullable = false)
        @JsonView(UserView.UserSummary::class)
        private val email: String = "",

        @Column(name = "password", nullable = false)
        @JsonView(UserView.UserSummary::class)
        @get:JvmName("get-password") private val password: String = "",

        @Column(name = "first")
        @JsonView(UserView.UserSummary::class)
        private val first: String? = null,

        @Column(name = "last")
        @JsonView(UserView.UserSummary::class)
        private val last: String? = null,

        @Column(name = "enabled", nullable = false)
        @JsonView(UserView.UserSummary::class)
        private val enabled: Boolean = false,

        @OneToMany
        @JoinTable(name = "user_bill",
                joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "bill_id", referencedColumnName = "id")))
        @JsonView(UserView.ExtendedUserSummary::class)
        private val bills: List<Bill> = ArrayList<Bill>()

) : UserDetails {

  override fun getAuthorities(): Collection<GrantedAuthority> {

    return ArrayList()
  }

  override fun isAccountNonExpired(): Boolean {
    return true
  }

  override fun isAccountNonLocked(): Boolean {
    // we never lock accounts
    return true
  }

  override fun isCredentialsNonExpired(): Boolean {
    // credentials never expire
    return true
  }

  override fun isEnabled(): Boolean {
    return enabled
  }

  override fun getUsername(): String? {
    return email
  }

  override fun getPassword(): String {
    return password
  }
}