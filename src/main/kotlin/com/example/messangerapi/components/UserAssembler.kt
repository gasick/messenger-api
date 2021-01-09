package com.example.messangerapi.components

import com.example.messangerapi.helpers.objects.UserListVO
import com.example.messangerapi.helpers.objects.UserVO
import com.example.messangerapi.models.User
import org.springframework.stereotype.Component

@Component
class UserAssembler {
    fun toUserVO(user: User?): UserVO{
        return UserVO(user.id,
        user.username,
        user.phoneNumber,
        user.status,
        user.createAt.toString()
        )
    }

    fun toUserListVO(users: List<User>): UserListVO {
        val userVOList = users.map { toUserVO(it)}
        return UserListVO(userVOList)
    }
}