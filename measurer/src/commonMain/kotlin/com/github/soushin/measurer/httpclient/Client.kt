package com.github.soushin.measurer.httpclient

interface Client {
    suspend fun call(baseUrl: String, request: HttpClient.Request, handleError: (Int) -> Unit): String
}
