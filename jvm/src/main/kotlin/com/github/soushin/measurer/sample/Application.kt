package com.github.soushin.measurer.sample

import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.install
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.pipeline.PipelineContext

@KtorExperimentalAPI
@KtorExperimentalLocationsAPI
fun Application.mainModule() {
    install(Locations)
    routing {
        track()
    }
}

@KtorExperimentalAPI
fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}

internal val PipelineContext<Unit, ApplicationCall>.trackingId
    get() = "your tracking id" // value is like `UA-12345678-1`
