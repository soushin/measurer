package com.github.soushin.measurer

import com.github.soushin.measurer.transport.ContentGroup

object GoogleAnalytics {

    private val httpClient = SampleHttpClient(SampleHttpClientConfig.httpClient, SampleNapierLogger())

    suspend fun pageTracking(ua: String) {
        val mp = MeasurementProtocol
            .Builder(
                trackingId = ua,
                httpClient = httpClient
            ).build()

        mp.also { ga ->
            ga.pageView("mydemo.com", "/home").apply {
                clientId = "555"
                documentTitle = "homgepage"

                contentGroup = ContentGroup(index = 1).apply {
                    value = "news/sports"
                }
            }

            ga.pageView("mydemo.com", "/home").apply {
                clientId = "555"
                documentTitle = "homgepage"

                contentGroup = ContentGroup(index = 2).apply {
                    value = "news/finance"
                }
            }
        }.send()
    }

    suspend fun eventTracking(ua: String) {
        val mp = MeasurementProtocol
            .Builder(
                trackingId = ua,
                httpClient = httpClient
            ).build()

        mp.also { ga ->
            ga.event("video", "play").apply {
                clientId = "555"
                eventLabel = "holiday"
                eventValue = 300
            }
        }.send()
    }
}