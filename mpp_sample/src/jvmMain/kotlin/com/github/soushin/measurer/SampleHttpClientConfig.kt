package com.github.soushin.measurer

import io.ktor.client.HttpClient
import io.ktor.client.engine.jetty.Jetty

actual class SampleHttpClientConfig {
    actual val httpClient = HttpClient(Jetty)
}
