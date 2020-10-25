package com.balionis.kotlin7.client

import mu.KotlinLogging
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

private val logger = KotlinLogging.logger {}

class AppConsumer(private val properties: Properties) : AppClient {

    private val stop = AtomicBoolean(false)
    private val consumer = KafkaConsumer<String, String>(properties)

    override fun run(args: List<String>) {
        logger.debug { "run: args=${args.joinToString()}" }

        consumer.apply {
            subscribe(listOf(Constants.TopicOut))
            thread(isDaemon = true) {
                while (!stop.get()) {
                    poll(Duration.ofHours(1)).forEach{ record ->
                        logger.debug { "run: key=${record.key()}, value=${record.value()} " }
                    }
                }
            }
        }
    }

    override fun close() {
        stop.set(true)
        kotlin.runCatching {
            consumer.close()
        }
    }
}