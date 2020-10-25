package com.balionis.kotlin7.client

import mu.KotlinLogging

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.*

import com.balionis.kotlin7.client.MoshiHelper.jsonAdapter

private val logger = KotlinLogging.logger {}

private val requestAdapter = MyRequest::class.java.jsonAdapter()

class AppProducer(private val properties: Properties) : AppClient {

    private val producer = KafkaProducer<String, String>(properties)

    override fun run(args: List<String>) {

        val json = requestAdapter.toJson(MyRequest(MyRequestPayload(args)))

        logger.debug { "run: args=${args.joinToString()}" }

        producer.send(
            ProducerRecord( Constants.TopicIn, "my-id", json)
        )

        producer.flush()
    }

    override fun close() {
        kotlin.runCatching {
            producer.close()
        }
    }
}