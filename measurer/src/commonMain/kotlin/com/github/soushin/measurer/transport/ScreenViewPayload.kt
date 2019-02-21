package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType

class ScreenViewPayload(
    screenName: String,
    trackingId: String,
    version: String = TransportConfig.VERSION
) : Payload() {
    init {
        this.trackingId = trackingId
        this.hit = HitType.ScreenView
        this.protocolVersion = version
        this.screenName = screenName
    }
}
