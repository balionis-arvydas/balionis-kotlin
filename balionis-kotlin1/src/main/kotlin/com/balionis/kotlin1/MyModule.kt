package com.balionis.kotlin1

import com.google.inject.AbstractModule
import com.google.inject.name.Names

class MyModule(private val args:MyArgs): AbstractModule() {
    override fun configure() {
        bind(String::class.java).annotatedWith(Names.named("MyServiceName")).toInstance(args.name)
        bind(MyAppRunner::class.java).to(MyAppRunnerImpl::class.java)
        bind(MyService::class.java).to(MyServiceImpl::class.java)
    }
}