package com.balionis.kotlin3

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class Handler : RequestHandler<String, String> {
    override fun handleRequest(input: String?, context: Context?): String {
        return "Hello, $input from Kotlin"
    }
}