package com.balionis.kotlin10

import mu.KotlinLogging
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate

private val logger = KotlinLogging.logger {}

class MyJavaDelegate : JavaDelegate {
    @Throws(Exception::class)
    override fun execute(execution: DelegateExecution) {
        logger.debug { "execute: +" }
    }
}
