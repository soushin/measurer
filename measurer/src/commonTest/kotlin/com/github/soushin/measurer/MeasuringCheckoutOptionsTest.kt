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

class MeasuringCheckoutOptionsTest {

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
    fun measuringCheckoutOptions() {

        val t = "event"
        val cid = 555
        val ec = "Checkout"
        val ea = "Option"
        val pa = "checkout_option"
        val cos = 2
        val col = "FedEx"

        val assertion: (HttpRequest) -> Unit = { httpRequest ->
            assertEquals(httpRequest.method, HttpMethod.Post)

            val payload = listOf(
                "tid=$UA",
                "t=$t",
                "v=$VERSION",

                "ec=${ec.encodeURLParameter()}",
                "ea=${ea.encodeURLParameter()}",

                "cid=$cid",

                "pa=${pa.encodeURLParameter()}",

                "cos=$cos",
                "col=${col.encodeURLParameter()}"

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
                ga.event(ec, ea).apply {
                    clientId = cid.toString()

                    productAction = pa

                    checkoutStep = cos
                    checkoutStepOption = col
                }
            }.send()
        }
    }
}
