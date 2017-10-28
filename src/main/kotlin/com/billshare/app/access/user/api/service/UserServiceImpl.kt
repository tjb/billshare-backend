package com.billshare.app.access.user.api.service

import com.billshare.app.Factory
import com.billshare.app.access.user.domain.User
import com.billshare.app.access.user.domain.UserRepository
import com.billshare.app.access.user.domain.toCurrentUser
import com.billshare.app.common.exception.EntityNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository, val userFactory: Factory<User, Void, User>): UserService {
  override fun findByEmail(email: String): User? {
    return userRepository.findByEmail(email)
  }

  override fun findById(id: Long): User {
      return userRepository.findById(id)
  }

  override fun create(user: User): User {
    return userRepository.save(userFactory.create(user, null))
  }

  override fun findByEmailAndPassword(email: String, password: String): User? {
    val encoder = BCryptPasswordEncoder()
    val user = userRepository.findByEmail(email)
    if (encoder.matches(password, user.password)) {
      return user
    } else {
      throw EntityNotFoundException()
    }
  }

  override fun loadUserByUsername(email: String): UserDetails {
    return userRepository.findByEmail(email).toCurrentUser()
  }
}