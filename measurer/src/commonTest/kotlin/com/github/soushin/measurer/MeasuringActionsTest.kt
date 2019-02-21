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

class MeasuringActionsTest {

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
    fun measuringActions() {

        val t = "event"
        val cid = 555

        val ec = "UX"
        val ea = "click"
        val el = "Results"

        val pa = "click"
        val pal = "Search Results"

        val pr1id = "P12345"
        val pr1nm = "Android Warhol T-Shirt"
        val pr1ca = "Apparel"
        val pr1br = "Google"
        val pr1va = "Black"
        val pr1ps = 1

        val pr1cd1 = "productA"
        val pr1cd2 = "productB"
        val pr1cm1 = 100
        val pr1cm2 = 200

        val pr2id = "P6789"
        val pr2nm = "Pixel Warhol T-Shirt"
        val pr2ca = "Apparel"
        val pr2br = "Pixel"
        val pr2va = "White"
        val pr2ps = 1

        val pr2cd1 = "productA"
        val pr2cd2 = "productB"
        val pr2cm1 = 100
        val pr2cm2 = 200

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
                "pal=${pal.encodeURLParameter()}",

                "pr1id=${pr1id.encodeURLParameter()}",
                "pr1nm=${pr1nm.encodeURLParameter()}",
                "pr1ca=${pr1ca.encodeURLParameter()}",
                "pr1br=${pr1br.encodeURLParameter()}",
                "pr1va=${pr1va.encodeURLParameter()}",
                "pr1ps=$pr1ps",

                "pr2id=${pr2id.encodeURLParameter()}",
                "pr2nm=${pr2nm.encodeURLParameter()}",
                "pr2ca=${pr2ca.encodeURLParameter()}",
                "pr2br=${pr2br.encodeURLParameter()}",
                "pr2va=${pr2va.encodeURLParameter()}",
                "pr2ps=$pr2ps",

                "pr1cd1=$pr1cd1",
                "pr1cd2=$pr1cd2",
                "pr2cd1=$pr2cd1",
                "pr2cd2=$pr2cd2",

                "pr1cm1=$pr1cm1",
                "pr1cm2=$pr1cm2",
                "pr2cm1=$pr2cm1",
                "pr2cm2=$pr2cm2"

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
                    productActionList = pal

                    product = Product(index = 1).apply {
                        sku = pr1id
                        name = pr1nm
                        category = pr1ca
                        brand = pr1br
                        variant = pr1va
                        position = pr1ps
                        customDimension = 1 to pr1cd1
                        customMetrics = 1 to pr1cm1
                        customDimension = 2 to pr1cd2
                        customMetrics = 2 to pr1cm2
                    }

                    product = Product(index = 2).apply {
                        sku = pr2id
                        name = pr2nm
                        category = pr2ca
                        brand = pr2br
                        variant = pr2va
                        position = pr2ps
                        customDimension = 1 to pr2cd1
                        customMetrics = 1 to pr2cm1
                        customDimension = 2 to pr2cd2
                        customMetrics = 2 to pr2cm2
                    }
                }
            }.send()
        }
    }
}
