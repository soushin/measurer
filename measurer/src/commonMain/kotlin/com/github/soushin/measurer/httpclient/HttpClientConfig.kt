package com.github.soushin.measurer.httpclient

import io.ktor.client.HttpClient

expect object HttpClientConfig {
    val httpClient: HttpClient
}
