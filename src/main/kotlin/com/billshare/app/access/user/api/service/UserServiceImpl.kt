package com.billshare.app.access.user.api.service

import com.billshare.app.access.user.domain.User
import com.billshare.app.access.user.domain.UserRepository
import com.billshare.app.access.user.domain.toCurrentUser
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository): UserService {

  override fun findById(id: Long): User {
      return userRepository.findById(id)
  }

  override fun create(user: User): User {
    return userRepository.save(user)
  }

  override fun loadUserByUsername(email: String): UserDetails {
    return userRepository.findByEmail(email).toCurrentUser()
  }


}