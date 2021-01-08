package com.example.messangerapi.services

import com.example.messangerapi.models.User

interface UserService {
    fun attemptRegistration(userDetails: User): User

    fun listUsers(currentUser: User): List<User>

    fun retriveUserData(username: String): User?

    fun retriveUserData(id: Long): User?

    fun usernameExists(username: String): Boolean
}