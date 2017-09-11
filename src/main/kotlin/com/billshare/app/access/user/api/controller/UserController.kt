package com.billshare.app.access.user.api.controller

import com.billshare.app.access.user.api.service.UserService
import com.billshare.app.access.user.domain.User
import com.billshare.app.access.user.domain.UserView
import com.fasterxml.jackson.annotation.JsonView
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = "/user")
open class UserController (val userService: UserService) {

    @GetMapping(value = "/{id}")
    @JsonView(UserView.ExtendedUserSummary::class)
    fun findById(@PathVariable id: Long): User {
        return userService.findById(id)
    }
}