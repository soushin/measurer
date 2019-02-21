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

class AppScreenTrackingTest {

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
    fun appScreenTracking() {

        val t = "screenview"
        val cid = 555

        val an = "funTimes"
        val av = "1.5.0"
        val aid = "com.foo.App"
        val aiid = "com.android.vending"

        val cd = "Home"

        val assertion: (HttpRequest) -> Unit = { httpRequest ->
            assertEquals(httpRequest.method, HttpMethod.Post)

            val payload = listOf(
                "tid=$UA",
                "t=$t",
                "v=$VERSION",

                "cd=${cd.encodeURLParameter()}",

                "cid=$cid",

                "an=${an.encodeURLParameter()}",
                "av=${av.encodeURLParameter()}",
                "aid=${aid.encodeURLParameter()}",
                "aiid=${aiid.encodeURLParameter()}"

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
                ga.screenView(cd).apply {
                    clientId = cid.toString()

                    applicationName = an
                    applicationVersion = av
                    applicationId = aid
                    applicationInstallerId = aiid
                }
            }.send()
        }
    }
}
