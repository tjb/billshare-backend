package com.billshare.app.access.user.api.service

import com.billshare.app.IFactory
import com.billshare.app.access.user.domain.CurrentUser
import com.billshare.app.access.user.domain.User
import org.springframework.stereotype.Service

@Service
class AuthenticatedUserFactory: IFactory<CurrentUser, Void, User> {
    override fun create(source1: CurrentUser?, source2: Void?): User {
        if(source1 == null)
            throw IllegalArgumentException();
        return User(id= source1.getId(),
                first = source1.getFirst(),
                last = source1.getLast(),
                enabled = source1.getEnabled(),
                email = source1.username!!,
                password = source1.password!!)
    }
}