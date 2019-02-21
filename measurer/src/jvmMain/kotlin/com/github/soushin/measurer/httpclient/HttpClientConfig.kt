package com.github.soushin.measurer.httpclient

import io.ktor.client.HttpClient
import io.ktor.client.engine.jetty.Jetty

actual object HttpClientConfig {
    actual val httpClient = HttpClient(Jetty) {
    }
}
