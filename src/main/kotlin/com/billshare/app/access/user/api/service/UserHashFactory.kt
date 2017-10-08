package com.billshare.app.access.user.api.service

import com.billshare.app.Factory
import com.billshare.app.access.user.domain.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserHashFactory(val encrypter: PasswordEncoder) : Factory<User, Void, User> {
    override fun create(source: User?, source2: Void?): User {
       if(source == null)
           throw IllegalArgumentException()
        return User(id = source.id,
                password = encrypter.encode(source.password),
                email = source.email,
                bills = source.bills,
                enabled = true,
                first = source.first,
                last = source.last)
    }
}