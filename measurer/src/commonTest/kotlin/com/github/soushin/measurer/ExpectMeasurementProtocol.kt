package com.github.soushin.measurer

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.request.HttpRequest

expect fun httpMockEngine(expectedUrl: String, res: String, assertion: (HttpRequest) -> Unit): HttpClientEngine
