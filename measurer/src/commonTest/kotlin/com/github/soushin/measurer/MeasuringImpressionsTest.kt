package com.github.soushin.measurer

import com.github.soushin.measurer.httpclient.Client
import com.github.soushin.measurer.httpclient.HttpClient
import com.github.soushin.measurer.httpclient.KtorClient
import com.github.soushin.measurer.transport.ProductImpressions
import com.github.soushin.measurer.transport.ProductImpressions.Product
import io.ktor.client.request.HttpRequest
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import io.ktor.http.encodeURLParameter
import kotlin.test.Test
import kotlin.test.assertEquals

class MeasuringImpressionsTest {

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
    fun measuringImpressions() {

        val t = "pageview"
        val cid = 555

        val dh = "mydemo.com"
        val dp = "/home"
        val dt = "homepage"

        val il1nm = "Search Results"
        val il1pi1id = "P12345"
        val il1pi1nm = "Android Warhol T-Shirt"
        val il1pi1ca = "Apparel T-Shirts"
        val il1pi1br = "Google"
        val il1pi1va = "Black"
        val il1pi1ps = 1

        val il2nm = "Recommended Products"
        val il2pi2nm = "Red T-Shirt"

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

                "il1nm=${il1nm.encodeURLParameter()}",
                "il2nm=${il2nm.encodeURLParameter()}",

                "il1pi1id=${il1pi1id.encodeURLParameter()}",
                "il1pi1nm=${il1pi1nm.encodeURLParameter()}",
                "il1pi1ca=${il1pi1ca.encodeURLParameter()}",
                "il1pi1br=${il1pi1br.encodeURLParameter()}",
                "il1pi1va=$il1pi1va",
                "il1pi1ps=$il1pi1ps",

                "il2pi2nm=${il2pi2nm.encodeURLParameter()}",

                "il1pi1cd1=productA",
                "il1pi1cd2=productB",
                "il2pi2cd1=productC",
                "il2pi2cd2=productD",

                "il1pi1cm1=100",
                "il1pi1cm2=200",
                "il2pi2cm1=300",
                "il2pi2cm2=400"

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

                    productImpression = ProductImpressions(listIndex = 1).apply {
                        listName = il1nm

                        product = Product(listIndex = this.listIndex, index = 1).apply {
                            sku = il1pi1id
                            name = il1pi1nm
                            category = il1pi1ca
                            brand = il1pi1br
                            variant = il1pi1va
                            position = il1pi1ps
                            customDimension = 1 to "productA"
                            customMetrics = 1 to 100
                            customDimension = 2 to "productB"
                            customMetrics = 2 to 200
                        }
                    }

                    productImpression = ProductImpressions(listIndex = 2).apply {
                        listName = il2nm

                        product = Product(listIndex = this.listIndex, index = 2).apply {
                            name = il2pi2nm
                            customDimension = 1 to "productC"
                            customMetrics = 1 to 300
                            customDimension = 2 to "productD"
                            customMetrics = 2 to 400
                        }
                    }
                }
            }.send()
        }
    }
}
