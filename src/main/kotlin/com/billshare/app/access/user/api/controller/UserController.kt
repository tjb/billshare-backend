package com.billshare.app.access.user.api.controller

import com.billshare.app.Factory
import com.billshare.app.access.user.api.service.UserService
import com.billshare.app.access.user.domain.User
import com.billshare.app.access.user.view.models.UserView
import com.billshare.app.access.user.view.models.UserViewModel
import com.fasterxml.jackson.annotation.JsonView
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = "/user")
class UserController (val userViewModelFactory: Factory<User, Void, UserViewModel>, val userService: UserService) {

  @GetMapping(value = "/{id}")
  @JsonView(UserView.ExtendedUserSummary::class)
  fun findById(@PathVariable id: Long): UserViewModel {
      val user = userService.findById(id)
      return userViewModelFactory.create(user, null)
  }

  @GetMapping(value = "/search/{email}")
  @JsonView(UserView.ExtendedUserSummary::class)
  fun findByEmail(@PathVariable email: String): UserViewModel {
    val user = userService.findByEmail(email)
    return userViewModelFactory.create(user, null)
  }

  @PostMapping(value = "/create")
  @JsonView(UserView.ExtendedUserSummary::class)
  fun create(@RequestBody user: User): UserViewModel {
    val createdUser = userService.create(user)
    return userViewModelFactory.create(createdUser, null)
  }

  @PostMapping(value = "/login")
  @JsonView(UserView.UserSummary::class)
  fun login(@RequestBody user: User): UserViewModel? {
    val foundUser = userService.findByEmailAndPassword(user.email, user.password)
    return userViewModelFactory.create(foundUser, null)
  }
}