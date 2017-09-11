package com.billshare.app.access.user.api.service

import com.billshare.app.access.user.domain.User

interface UserService {

    fun findById(id: Long): User

}