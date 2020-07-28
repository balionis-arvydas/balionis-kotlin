package com.balionis.kotlin1

data class MyArgs(val name: String, val message: String) {
    companion object {
        fun parse(args:List<String>): MyArgs {
            var name = "myName"
            var message = "myMessage"
            for (i in args.indices step 2) {
                when(args[i]) {
                    "--name" -> {
                        name = args.getOrElse(i+1) { name }
                    }
                    "--message" -> {
                        message = args.getOrElse(i+1) { message }
                    }
                }
            }
            return MyArgs(name, message)
        }
    }
}