package com.example.messangerapi.components

import com.example.messangerapi.constants.ErrorResponse
import com.example.messangerapi.constants.ResponseConstants
import com.example.messangerapi.exceptions.UserDeactivatedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestcontrollerAdvice {
    @ExceptionHandler(UserDeactivatedException::class)
    fun userDeactivated(userDeactivatedException: UserDeactivatedException): ResponseEntity<ErrorResponse>{
        val res = ErrorResponse(
            ResponseConstants.ACCOUNT_DEACTIVATED.value,
            userDeactivatedException.message)
        return ResponseEntity(res, HttpStatus.UNAUTHORIZED)
    }
}