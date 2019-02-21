package com.github.soushin.measurer

import io.ktor.client.HttpClient
import io.ktor.client.engine.jetty.Jetty

actual object SampleHttpClientConfig {
    actual val httpClient = HttpClient(Jetty)
}
