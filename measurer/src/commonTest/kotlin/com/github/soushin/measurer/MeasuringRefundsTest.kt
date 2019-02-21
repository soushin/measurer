package com.github.soushin.measurer

import com.github.soushin.measurer.httpclient.Client
import com.github.soushin.measurer.httpclient.HttpClient
import com.github.soushin.measurer.httpclient.KtorClient
import com.github.soushin.measurer.transport.Product
import io.ktor.client.request.HttpRequest
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import io.ktor.http.encodeURLParameter
import kotlin.test.Test
import kotlin.test.assertEquals

class MeasuringRefundsTest {

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
    fun measuringRefunds() {

        val t = "event"
        val cid = 555

        val ec = "Ecommerce"
        val ea = "Refund"
        val ni = true
        val niValue = "1"

        val ti = "T12345"
        val pa = "refund"
        val pr1id = "P12345"
        val pr1qt = 1

        val assertion: (HttpRequest) -> Unit = { httpRequest ->
            assertEquals(httpRequest.method, HttpMethod.Post)

            val payload = listOf(
                "tid=$UA",
                "t=$t",
                "v=$VERSION",

                "ec=${ec.encodeURLParameter()}",
                "ea=${ea.encodeURLParameter()}",

                "cid=$cid",

                "ni=${niValue}",

                "ti=${ti.encodeURLParameter()}",
                "pa=${pa.encodeURLParameter()}",
                "pr1id=${pr1id.encodeURLParameter()}",
                "pr1qt=$pr1qt"

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

                    nonInteractionHit = ni

                    transactionId = ti
                    productAction = pa
                    product = Product(index = 1).apply {
                        sku = pr1id
                        quantity = pr1qt
                    }
                }
            }.send()
        }
    }
}
