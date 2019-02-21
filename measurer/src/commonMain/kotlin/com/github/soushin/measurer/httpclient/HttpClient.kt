package com.github.soushin.measurer.httpclient

abstract class HttpClient {

    abstract class Request {
        abstract val method: String
        abstract val path: String
        abstract val userAgent: String
        open val body: String? = null
        open val headers = emptyMap<String, String>()
        open val queries = emptyMap<String, String>()
    }

    abstract val baseUrl: String
    abstract val client: Client

    suspend fun request(request: Request) = client.call(baseUrl, request) {
        this.error(it)
    }

    abstract fun error(statusCode: Int)
}
