package com.example.springbootkafkapoc.gateway.input.rest

import com.example.springbootkafkapoc.usecase.SendMessageUseCase
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val sendMessageUseCase: SendMessageUseCase
) {
    @GetMapping("/health")
    fun health(): String {
        return """ { "success": true } """
    }

    @ResponseStatus(OK)
    @PostMapping("/messages")
    fun sendMessage() {
        sendMessageUseCase.send()
    }

}