package com.github.soushin.measurer.sample

import com.github.soushin.measurer.GoogleAnalytics
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
            GoogleAnalytics().pageTracking(tid = trackingId)
            GoogleAnalytics().eventTracking(tid = trackingId)
            respond("tracked")
        }
    }
}
