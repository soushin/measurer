package com.github.soushin.measurer.httpclient

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

actual object HttpClientConfig {
    actual val httpClient = HttpClient(Android)
}
