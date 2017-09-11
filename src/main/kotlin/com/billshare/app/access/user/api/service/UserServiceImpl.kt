package com.billshare.app.access.user.api.service

import com.billshare.app.access.user.domain.User
import com.billshare.app.access.user.domain.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository): UserService {

    override fun findById(id: Long): User {
        return userRepository.findById(id)
    }

}