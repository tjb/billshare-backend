package com.billshare.app.access.user.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

  fun findById(id: Long): User

  fun findByEmail(email: String): User

  fun findByEmailAndPassword(email:String, password: String): User?

}