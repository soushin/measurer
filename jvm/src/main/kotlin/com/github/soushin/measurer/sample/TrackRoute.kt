package com.github.soushin.measurer.sample

import com.github.soushin.measurer.MeasurementProtocol
import io.ktor.application.call
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route

@KtorExperimentalLocationsAPI
@Location("/track")
class Track

@KtorExperimentalLocationsAPI
fun Route.track() {
    get<Track> {
        call.apply {
            send(trackingId)
            respond("tracked")
        }
    }
}

suspend fun send(trackingId: String) {
    val mp = MeasurementProtocol
        .Builder(trackingId = trackingId)
        .build()

    mp.also { ga ->
        ga.pageView(documentHostName = "hostname", documentPath = "/foo/bar").apply {
            userAgentOverride = UserAgent.get()
            clientId = ('A'..'z').map { it }.shuffled().subList(0, 10).joinToString("")
            documentLocationUrl = "/foo/bar"
            applicationName = "Measurer SampleApp"
        }
    }.send()
}
