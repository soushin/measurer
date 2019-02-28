package com.github.soushin.measurer

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockHttpResponse
import io.ktor.client.request.HttpRequest
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.http.hostWithPort
import kotlinx.coroutines.io.ByteReadChannel
import kotlinx.serialization.toUtf8Bytes

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
                    ByteReadChannel(res.toUtf8Bytes()),
                    headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
                )
            }
            else -> {
                error("Unhandled ${url.fullUrl}")
            }
        }
    }
