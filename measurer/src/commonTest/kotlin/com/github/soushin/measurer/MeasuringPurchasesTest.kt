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

class MeasuringPurchasesTest {

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
    fun measuringPurchases() {

        val t = "pageview"
        val cid = 555

        val dh = "mydemo.com"
        val dp = "/receipt"
        val dt = "Receipt Page"

        val ti = "T12345"
        val ta = "Google Store - Online"
        val tr = 37.39
        val tt = 2.85
        val ts = 5.34
        val tcc = "SUMMER2013"

        val pa = "purchase"
        val pr1id = "P12345"
        val pr1nm = "Android Warhol T-Shirt"
        val pr1ca = "Apparel"
        val pr1br = "Google"
        val pr1va = "Black"
        val pr1ps = 1

        val assertion: (HttpRequest) -> Unit = { httpRequest ->
            assertEquals(httpRequest.method, HttpMethod.Post)

            val payload = listOf(
                "tid=$UA",
                "t=$t",
                "v=$VERSION",

                "dh=${dh.encodeURLParameter()}",
                "dp=${dp.encodeURLParameter()}",

                "cid=$cid",
                "dt=${dt.encodeURLParameter()}",

                "ti=${ti.encodeURLParameter()}",
                "ta=${ta.encodeURLParameter()}",
                "tr=$tr",
                "tt=$tt",
                "ts=$ts",
                "tcc=$tcc",

                "pa=${pa.encodeURLParameter()}",
                "pr1id=${pr1id.encodeURLParameter()}",
                "pr1nm=${pr1nm.encodeURLParameter()}",
                "pr1ca=${pr1ca.encodeURLParameter()}",
                "pr1br=${pr1br.encodeURLParameter()}",
                "pr1va=${pr1va.encodeURLParameter()}",
                "pr1ps=$pr1ps"

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
                ga.pageView(dh, dp).apply {
                    clientId = cid.toString()
                    documentTitle = dt

                    transactionId = ti
                    affiliation = ta
                    revenue = tr
                    tax = tt
                    shipping = ts
                    couponCode = tcc

                    productAction = pa
                    product = Product(index = 1).apply {
                        sku = pr1id
                        name = pr1nm
                        category = pr1ca
                        brand = pr1br
                        variant = pr1va
                        position = pr1ps
                    }
                }
            }.send()
        }
    }
}
