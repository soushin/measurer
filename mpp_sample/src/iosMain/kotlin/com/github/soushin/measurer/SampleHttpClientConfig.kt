package com.github.soushin.measurer

import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.Ios

actual class SampleHttpClientConfig {
    actual val httpClient = HttpClient(Ios)
}
