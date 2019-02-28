package com.github.soushin.measurer

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js

actual class SampleHttpClientConfig {
    actual val httpClient = HttpClient(Js)
}
