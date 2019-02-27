package com.github.soushin.measurer.transport

import com.github.soushin.measurer.httpclient.HttpClient

class PostBatch(
    override val userAgent: String,
    override val body: String
) : HttpClient.Request() {
    override val method = "POST"
    override val path = "/batch"
}
