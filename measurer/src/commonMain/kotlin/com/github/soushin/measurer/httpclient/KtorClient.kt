package com.github.soushin.measurer.httpclient

import io.ktor.client.call.call
import io.ktor.client.request.headers
import io.ktor.client.response.readText
import io.ktor.http.HttpMethod
import io.ktor.http.URLBuilder
import io.ktor.http.isSuccess
import io.ktor.http.userAgent

class KtorClient(private val client: io.ktor.client.HttpClient) :
    Client {

    override suspend fun call(
        baseUrl: String,
        request: HttpClient.Request,
        handleError: (Int) -> Unit
    ) =
        URLBuilder(baseUrl).apply {
            encodedPath = request.path.trimStart('/')
            request.queries.forEach {
                parameters.append(it.key, it.value)
            }
        }.build().let { url ->
            client.call(url) {
                this.userAgent(request.userAgent)
                this.method = HttpMethod(request.method)
                this.headers {
                    clear()
                    request.headers.map {
                        append(it.key, it.value)
                    }
                }
                request.body?.let { req ->
                    this.body = req
                }
            }.also {
                if (!it.response.status.isSuccess()) handleError(it.response.status.value)
            }.let {
                it.response.readText()
            }
        }
}
