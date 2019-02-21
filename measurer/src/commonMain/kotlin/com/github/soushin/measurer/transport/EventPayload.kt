package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType

class EventPayload(
    eventCategory: String,
    eventAction: String,
    trackingId: String,
    version: String = TransportConfig.VERSION
) : Payload() {
    init {
        this.trackingId = trackingId
        this.hit = HitType.Event
        this.protocolVersion = version
        this.eventCategory = eventCategory
        this.eventAction = eventAction
    }
}
