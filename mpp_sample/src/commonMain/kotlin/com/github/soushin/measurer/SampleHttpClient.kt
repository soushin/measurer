package com.github.soushin.measurer

import com.github.soushin.measurer.httpclient.Client
import com.github.soushin.measurer.httpclient.HttpClient
import com.github.soushin.measurer.httpclient.KtorClient
import com.github.soushin.measurer.transport.TransportConfig

class SampleHttpClient(cli: io.ktor.client.HttpClient, private val log: Logger) : HttpClient() {
    override val client: Client = KtorClient(cli)
    override val baseUrl: String = TransportConfig.BASE_URL
    override fun error(statusCode: Int) {
        log.e("Google Analytics http error: status=$statusCode")
    }
}
