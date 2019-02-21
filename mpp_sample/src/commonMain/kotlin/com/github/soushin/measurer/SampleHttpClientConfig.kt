package com.github.soushin.measurer

import io.ktor.client.HttpClient

expect object SampleHttpClientConfig {
    val httpClient: HttpClient
}
