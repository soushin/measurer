package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType

class PageViewPayload(
    documentHostName: String,
    documentPath: String,
    trackingId: String,
    version: String = TransportConfig.VERSION
) : Payload() {
    init {
        this.trackingId = trackingId
        this.hit = HitType.PageView
        this.protocolVersion = version
        this.documentHostName = documentHostName
        this.documentPath = documentPath
    }
}
