package com.example.springbootkafkapoc.gateway.output.kafka

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducer (
    private val kafkaTemplate: KafkaTemplate<String, String>,

    @Value(value = "\${spring.kafka.topic.top:top-top-top}")
    private val topic: String,

){

    fun sendMessage(message: String){
        kafkaTemplate.send(topic, message)
    }

}