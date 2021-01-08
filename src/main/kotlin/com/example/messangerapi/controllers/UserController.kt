package com.example.messangerapi.controllers

import com.example.messangerapi.models.User
import com.example.messangerapi.repositories.UserRepository
import com.example.messangerapi.services.UserServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserServiceImpl,
    val userRepository: UserRepository) {
    @PostMapping
    @RequestMapping("/registrations")
    fun create(@Validated @RequestBody userDetails: User): ResponseEntity<User> {
        val user = userService.attemptRegistration(userDetails)
        return ResponseEntity.ok(user)
    }
}