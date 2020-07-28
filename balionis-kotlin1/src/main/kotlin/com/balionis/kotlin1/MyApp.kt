package com.balionis.kotlin1

import com.google.inject.Guice
import org.slf4j.LoggerFactory
import org.slf4j.Logger

object MyApp {
    val LOGGER: Logger = LoggerFactory.getLogger(MyService::class.java)
}

fun main(args: Array<String>) {
    MyApp.LOGGER.info("main: args=${args.joinToString()}")

    val runnerArgs = MyArgs.parse(args.asList())

    val injector = Guice.createInjector(MyModule(runnerArgs))

    val runner: MyAppRunner = injector.getInstance(MyAppRunner::class.java)
    runner.run(runnerArgs)

    MyApp.LOGGER.info("main: done")
}

