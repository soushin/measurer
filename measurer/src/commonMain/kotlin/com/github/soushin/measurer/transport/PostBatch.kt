package com.github.soushin.measurer.transport

import com.github.soushin.measurer.httpclient.HttpClient
import io.ktor.http.HttpMethod

class PostBatch(
    override val userAgent: String,
    override val body: String
) : HttpClient.Request() {
    override val method = HttpMethod.Post.value
    override val path = "/batch"
}
