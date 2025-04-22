package com.es.mongoapi.ADA05_API.controller

import com.es.mongoapi.ADA05_API.model.User
import com.es.mongoapi.ADA05_API.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController(private val userRepository: UserRepository) {

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val savedUser = userRepository.save(user)
        return ResponseEntity.ok(savedUser)
    }

}
