package com.billshare.app.access.user.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.ArrayList



class CurrentUser : UserDetails {

  private var id: Long? = null
  private var first: String
  private var last: String
  private var enabled: Boolean
  private var username: String
  private var password: String

  constructor(id: Long?, first: String, last: String, email: String, password: String, enabled: Boolean) {
    this.id = id
    this.first = first
    this.last = last
    this.username = email
    this.password = password
    this.enabled = enabled
  }

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
    return username
  }

  override fun getPassword(): String? {
    return password
  }

  fun getId(): Long? {
    return id;
  }

  fun getFirst(): String {
    return first;
  }

  fun getLast(): String {
    return last;
  }

  fun getEnabled(): Boolean {
    return enabled;
  }
}