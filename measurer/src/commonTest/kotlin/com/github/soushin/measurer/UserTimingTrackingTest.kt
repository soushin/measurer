package com.github.soushin.measurer

import com.github.soushin.measurer.httpclient.Client
import com.github.soushin.measurer.httpclient.HttpClient
import com.github.soushin.measurer.httpclient.KtorClient
import io.ktor.client.request.HttpRequest
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import io.ktor.http.encodeURLParameter
import kotlin.test.Test
import kotlin.test.assertEquals

class UserTimingTrackingTest {

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
    fun userTimingTracking() {

        val t = "timing"
        val cid = 555

        val utc = "jsonLoader"
        val utv = "load"
        val utt = 5000
        val utl = "jQuery"

        val dns = 100
        val pdt = 20
        val rrt = 32
        val tcp = 56
        val srt = 12

        val assertion: (HttpRequest) -> Unit = { httpRequest ->
            assertEquals(httpRequest.method, HttpMethod.Post)

            val payload = listOf(
                "tid=$UA",
                "t=$t",
                "v=$VERSION",

                "utc=${utc.encodeURLParameter()}",
                "utv=${utv.encodeURLParameter()}",
                "utt=$utt",

                "cid=$cid",

                "utl=${utl.encodeURLParameter()}",

                "dns=$dns",
                "pdt=$pdt",
                "rrt=$rrt",
                "tcp=$tcp",
                "srt=$srt"

            ).joinToString("&")

            (httpRequest.content as TextContent).run {
                assertEquals(payload, text)
            }
        }

        val httpMockEngine = httpMockEngine(
            "http://localhost/collect",
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
                ga.timing(utc, utv, utt).apply {
                    clientId = cid.toString()

                    userTimingLabel = utl

                    dnsTime = dns
                    pageDownloadTime = pdt
                    redirectResponseTime = rrt
                    tcpConnectTime = tcp
                    serverResponseTime = srt
                }
            }.send()
        }
    }
}
