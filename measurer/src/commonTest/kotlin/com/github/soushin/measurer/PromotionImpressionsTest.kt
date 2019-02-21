package com.github.soushin.measurer

import com.github.soushin.measurer.httpclient.Client
import com.github.soushin.measurer.httpclient.HttpClient
import com.github.soushin.measurer.httpclient.KtorClient
import com.github.soushin.measurer.transport.Promotion
import io.ktor.client.request.HttpRequest
import io.ktor.http.HttpMethod
import io.ktor.http.content.TextContent
import io.ktor.http.encodeURLParameter
import kotlin.test.Test
import kotlin.test.assertEquals

class PromotionImpressionsTest {

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
    fun promotionImpressions() {

        val t = "pageview"
        val cid = 555
        val dh = "mydemo.com"
        val dp = "/home"
        val dt = "homepage"

        val promo1id = "PROMO_1234"
        val promo1nm = "Summer Sale"
        val promo1cr = "summer_banner2"
        val promo1ps = "banner_slot1"

        val promo2id = "PROMO_5678"
        val promo2nm = "Spring Sale"
        val promo2cr = "spring_banner2"
        val promo2ps = "banner_slot2"

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

                "promo1id=${promo1id.encodeURLParameter()}",
                "promo1nm=${promo1nm.encodeURLParameter()}",
                "promo1cr=${promo1cr.encodeURLParameter()}",
                "promo1ps=${promo1ps.encodeURLParameter()}",

                "promo2id=${promo2id.encodeURLParameter()}",
                "promo2nm=${promo2nm.encodeURLParameter()}",
                "promo2cr=${promo2cr.encodeURLParameter()}",
                "promo2ps=${promo2ps.encodeURLParameter()}"

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

                    promotion = Promotion(index = 1).apply {
                        id = promo1id
                        name = promo1nm
                        creative = promo1cr
                        position = promo1ps
                    }

                    promotion = Promotion(index = 2).apply {
                        id = promo2id
                        name = promo2nm
                        creative = promo2cr
                        position = promo2ps
                    }
                }
            }.send()
        }
    }
}
