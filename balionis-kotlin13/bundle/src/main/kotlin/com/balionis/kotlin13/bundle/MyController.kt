package com.balionis.kotlin13.bundle

import io.zeebe.client.ZeebeClient
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/bundle")
class MyController {

    @Value("#{environment.ZEEBE_BROKER}")
    lateinit var broker: String

    @GetMapping("/echo")
    fun echo(@RequestParam(required = false) name: String?) : String {
        logger.debug { "echo: name=$name" }

        val res = "Hello, ${name ?: "Engine"}!"

        logger.debug { "echo: res=$res" }

        return res
    }

    @GetMapping("/deploy/{name}")
    fun deploy(@PathVariable name: String, @RequestParam file: MultipartFile) : String {
        logger.debug { "deploy: name=$, broker=$broker" }

        val clientBuilder = ZeebeClient.newClientBuilder().brokerContactPoint(broker).usePlaintext()
        val version = clientBuilder.build().use { client ->
            val deployment = client.newDeployCommand()
                    .addResourceStream(file.inputStream, name)
                    .send()
                    .join()
            deployment.workflows[0].version;
        }

        val res = "{\"payload\": \"$version\" }"

        logger.debug { "deploy: res=$res" }

        return res
    }
}
