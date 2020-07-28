package com.balionis.kotlin1

import com.google.inject.Inject

import org.slf4j.LoggerFactory

interface MyAppRunner {
    fun run(args: MyArgs)
}

class MyAppRunnerImpl @Inject constructor(private val service: MyService): MyAppRunner {
    override fun run(args: MyArgs) {
        val res = service.echo(args.message)

        LOGGER.info("run: res={}", res)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(MyAppRunnerImpl::class.java)
    }
}
