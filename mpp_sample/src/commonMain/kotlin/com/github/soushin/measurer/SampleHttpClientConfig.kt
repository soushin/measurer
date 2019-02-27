package com.github.soushin.measurer

import io.ktor.client.HttpClient

expect class SampleHttpClientConfig() {
    val httpClient: HttpClient
}
