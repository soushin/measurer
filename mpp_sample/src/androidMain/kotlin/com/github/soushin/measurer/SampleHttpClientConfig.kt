package com.github.soushin.measurer

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

actual class SampleHttpClientConfig {
    actual val httpClient = HttpClient(Android)
}
