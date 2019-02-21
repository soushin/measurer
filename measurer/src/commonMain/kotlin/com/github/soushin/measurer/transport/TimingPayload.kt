package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType

class TimingPayload(
    userTimingCategory: String,
    userTimingVariableName: String,
    userTimingTime: Int,
    trackingId: String,
    version: String = TransportConfig.VERSION
) : Payload() {
    init {
        this.trackingId = trackingId
        this.hit = HitType.Timing
        this.protocolVersion = version
        this.userTimingCategory = userTimingCategory
        this.userTimingVariableName = userTimingVariableName
        this.userTimingTime = userTimingTime
    }
}
