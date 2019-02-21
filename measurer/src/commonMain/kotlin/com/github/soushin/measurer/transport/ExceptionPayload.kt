package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType

class ExceptionPayload(
    trackingId: String,
    version: String = TransportConfig.VERSION
) : Payload() {
    init {
        this.trackingId = trackingId
        this.hit = HitType.Exception
        this.protocolVersion = version
    }
}
