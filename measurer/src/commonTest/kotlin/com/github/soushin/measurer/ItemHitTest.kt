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

class ItemHitTest {

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
    fun transactionHit() {

        val t = "item"
        val cid = 555

        val ti = 12345
        val itemName = "sofa"
        val ip = 300
        val iq = 2
        val ic = "u3eqds43"
        val iv = "furniture"
        val cu = "EUR"

        val assertion: (HttpRequest) -> Unit = { httpRequest ->
            assertEquals(httpRequest.method, HttpMethod.Post)

            val payload = listOf(
                "tid=$UA",
                "t=$t",
                "v=$VERSION",
                "ti=$ti",
                "in=${itemName.encodeURLParameter()}",

                "cid=$cid",

                "ip=${ip.toDouble()}",
                "iq=$iq",
                "ic=${ic.encodeURLParameter()}",
                "iv=${iv.encodeURLParameter()}",
                "cu=$cu"
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
                ga.item(ti.toString(), itemName).apply {
                    clientId = cid.toString()

                    itemPrice = ip.toDouble()
                    itemQuantity = iq
                    itemCode = ic
                    itemCategory = iv

                    currencyCode = cu
                }
            }.send()
        }
    }
}
