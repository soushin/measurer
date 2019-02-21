package com.github.soushin.measurer

import com.github.soushin.measurer.httpclient.Client
import com.github.soushin.measurer.httpclient.HttpClient
import com.github.soushin.measurer.httpclient.KtorClient
import com.github.soushin.measurer.transport.ContentGroup
import io.ktor.client.request.HttpRequest
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import io.ktor.http.encodeURLParameter
import kotlin.test.Test
import kotlin.test.assertEquals

class PageTrackingTest {

    companion object {
        private val VERSION = "1"
        private val UA = "UA-12345678-1"
    }

    private class MockHttpClient(cli: io.ktor.client.HttpClient) : HttpClient() {
        override val baseUrl: String = "http://localhost"
        override val client: Client = KtorClient(cli)
        override fun error(statusCode: Int) {
            throw IllegalArgumentException("mock http client error")
        }
    }

    @Test
    fun pageTracking() {

        val t = "pageview"
        val cid = 555

        val dh = "mydemo.com"
        val dp = "/home"
        val dt = "homepage"

        val cd1 = "news/sports"
        val cd2 = "news/finance"

        val assertion: (HttpRequest) -> Unit = { httpRequest ->
            assertEquals(httpRequest.method, HttpMethod.Post)

            val payloads = mutableListOf<String>()

            payloads.add(
                listOf(
                    "tid=$UA",
                    "t=$t",
                    "v=$VERSION",
                    "dh=${dh.encodeURLParameter()}",
                    "dp=${dp.encodeURLParameter()}",
                    "cid=$cid",
                    "dt=${dt.encodeURLParameter()}",

                    "cd1=${cd1.encodeURLParameter()}"
                ).joinToString("&")
            )

            payloads.add(
                listOf(
                    "tid=$UA",
                    "t=$t",
                    "v=$VERSION",
                    "dh=${dh.encodeURLParameter()}",
                    "dp=${dp.encodeURLParameter()}",
                    "cid=$cid",
                    "dt=${dt.encodeURLParameter()}",

                    "cd2=${cd2.encodeURLParameter()}"
                ).joinToString("&")
            )

            val payload = payloads.joinToString("\n")

            (httpRequest.content as TextContent).run {
                assertEquals(payload, text)
            }
        }

        val httpMockEngine = httpMockEngine(
            "http://localhost/batch",
            "collected",
            assertion
        )

        val mp = MeasurementProtocol
            .Builder(
                trackingId = UA,
                httpClient = MockHttpClient(io.ktor.client.HttpClient(httpMockEngine))
            ).build()

        runTest {
            mp.also { ga ->
                ga.pageView(dh, dp).apply {
                    clientId = cid.toString()
                    documentTitle = dt

                    contentGroup = ContentGroup(index = 1).apply {
                        value = cd1
                    }
                }

                ga.pageView(dh, dp).apply {
                    clientId = cid.toString()
                    documentTitle = dt

                    contentGroup = ContentGroup(index = 2).apply {
                        value = cd2
                    }
                }
            }.send()
        }
    }
}
