package com.github.soushin.measurer

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockHttpResponse
import io.ktor.client.request.HttpRequest
import io.ktor.http.*
import kotlinx.coroutines.io.ByteReadChannel

internal val Url.fullUrl: String get() = "${protocol.name}://$hostWithPortIfRequired$fullPath"
internal val Url.hostWithPortIfRequired: String get() = if (port == protocol.defaultPort) host else hostWithPort

actual fun httpMockEngine(expectedUrl: String, res: String, assertion: (HttpRequest) -> Unit): HttpClientEngine =
    MockEngine {

        assertion(this)

        when (url.fullUrl) {
            expectedUrl -> {

                MockHttpResponse(
                    call,
                    HttpStatusCode.OK,
                    ByteReadChannel(res.toByteArray(Charsets.UTF_8)),
                    headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                )
            }
            else -> {
                error("Unhandled ${url.fullUrl}")
            }
        }
    }
