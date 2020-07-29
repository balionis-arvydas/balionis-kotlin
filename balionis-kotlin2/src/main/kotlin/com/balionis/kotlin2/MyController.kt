package com.balionis.kotlin2

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicInteger

@RestController
class MyController(private val counter: AtomicInteger = AtomicInteger()) {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(MyController::class.java)
    }

    @GetMapping("/echo")
    fun echo(@RequestParam(value = "message", defaultValue = "") msg: String): MyMessage {
        LOGGER.info("echo: msg={}", msg)

        val res = MyMessage(counter.incrementAndGet(), msg)
        LOGGER.info("echo: res={}", res)

        return res
    }
}