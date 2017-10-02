package com.billshare.app.access.user.api.service

import com.billshare.app.access.user.domain.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService: UserDetailsService {

  fun findById(id: Long): User

  fun create(user: User): User

  fun findByEmailAndPassword(email: String, password: String): User?

}