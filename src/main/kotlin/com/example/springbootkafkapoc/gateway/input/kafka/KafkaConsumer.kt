package com.example.springbootkafkapoc.gateway.input.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.PartitionOffset
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class KafkaConsumer {

    val logger : Logger = LoggerFactory.getLogger(KafkaConsumer::class.java)

    @KafkaListener(
        id = "consumer-group-top1",
        containerFactory = "kafkaListenerContainerFactory",
        topicPartitions = [
            TopicPartition(topic = "top-top-top",
                partitionOffsets = [PartitionOffset(partition = "0", initialOffset = "5")]
            )
        ]
    )
    fun listenWithHeaders(
        @Payload message: String,
        @Header(KafkaHeaders.OFFSET) offSet: Long,
        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partition: Int) {

        logger.info("Received Message: $message from partition: $partition and offset: $offSet")
    }
}