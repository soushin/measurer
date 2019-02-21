package com.github.soushin.measurer

import com.github.soushin.measurer.httpclient.Client
import com.github.soushin.measurer.httpclient.HttpClient
import com.github.soushin.measurer.httpclient.KtorClient
import com.github.soushin.measurer.transport.Product
import com.github.soushin.measurer.transport.ProductImpressions
import io.ktor.client.request.HttpRequest
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import io.ktor.http.encodeURLParameter
import kotlin.test.Test
import kotlin.test.assertEquals

class CombiningImpressionsAndActionsTest {

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
    fun combiningImpressionsAndActions() {
        val t = "event"
        val cid = 555

        val ec = "UX"
        val ea = "click"
        val el = "Results"

        val pa = "detail"

        val pr1id = "P12345"
        val pr1nm = "Android Warhol T-Shirt"
        val pr1ca = "Apparel"
        val pr1br = "Google"
        val pr1va = "Black"
        val pr1ps = 1

        val il1nm = "Related Products"
        val il1pi1id = "P12345"
        val il1pi1nm = "Android%20Warhol%20T-Shirt"
        val il1pi1ca = "Apparel%2FT-Shirts"
        val il1pi1br = "Google"
        val il1pi1va = "Black"
        val il1pi1ps = 1

        val assertion: (HttpRequest) -> Unit = { httpRequest ->
            assertEquals(httpRequest.method, HttpMethod.Post)

            val payload = listOf(
                "tid=$UA",
                "t=$t",
                "v=$VERSION",
                "ec=${ec.encodeURLParameter()}",
                "ea=${ea.encodeURLParameter()}",
                "cid=$cid",
                "el=${el.encodeURLParameter()}",

                "pa=${pa.encodeURLParameter()}",

                "pr1id=${pr1id.encodeURLParameter()}",
                "pr1nm=${pr1nm.encodeURLParameter()}",
                "pr1ca=${pr1ca.encodeURLParameter()}",
                "pr1br=${pr1br.encodeURLParameter()}",
                "pr1va=${pr1va.encodeURLParameter()}",
                "pr1ps=$pr1ps",

                "il1nm=${il1nm.encodeURLParameter()}",
                "il1pi1id=${il1pi1id.encodeURLParameter()}",
                "il1pi1nm=${il1pi1nm.encodeURLParameter()}",
                "il1pi1ca=${il1pi1ca.encodeURLParameter()}",
                "il1pi1br=${il1pi1br.encodeURLParameter()}",
                "il1pi1va=${il1pi1va.encodeURLParameter()}",
                "il1pi1ps=$il1pi1ps"

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
                    eventLabel = el

                    productAction = pa

                    product = Product(index = 1).apply {
                        sku = pr1id
                        name = pr1nm
                        category = pr1ca
                        brand = pr1br
                        variant = pr1va
                        position = pr1ps
                    }

                    productImpression = ProductImpressions(listIndex = 1).apply {
                        listName = il1nm

                        product = ProductImpressions.Product(listIndex = this.listIndex, index = 1).apply {
                            sku = il1pi1id
                            name = il1pi1nm
                            category = il1pi1ca
                            brand = il1pi1br
                            variant = il1pi1va
                            position = il1pi1ps
                        }
                    }
                }
            }.send()
        }
    }
}
