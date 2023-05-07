package org.example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.InputStream
import java.io.OutputStream

class LambdaRequestHandlerRename4 : RequestStreamHandler {
    private val mapper = jacksonObjectMapper()

    override fun handleRequest(inputStream: InputStream?, output: OutputStream?, context: Context?) {
        val input = mapper.readValue(inputStream, InputObject::class.java)
        context?.logger?.log("Input: $input")

        mapper.writeValue(output, "Hello $input")
    }
}


data class InputObject(val key1: String, var key2: String, val key3: String)