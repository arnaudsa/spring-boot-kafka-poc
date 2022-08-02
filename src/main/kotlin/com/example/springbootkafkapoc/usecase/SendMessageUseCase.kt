package com.example.springbootkafkapoc.usecase

import com.example.springbootkafkapoc.gateway.output.kafka.KafkaProducer
import java.util.UUID
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SendMessageUseCase(
    private val producer: KafkaProducer
) {

    val logger : Logger = LoggerFactory.getLogger(SendMessageUseCase::class.java)
    val stringLength = 10
    val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun send(){
        val message = buildMessage()
        logger.info("Send message to kafka topic: top-top-top message: $message")
        producer.sendMessage(message)
    }

    internal fun buildMessage(): String{
        val id = UUID.randomUUID().toString()
        val randomString = (1..stringLength)
            .map { kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
        return """ { "id": "$id", "message": "$randomString" } """
    }
}