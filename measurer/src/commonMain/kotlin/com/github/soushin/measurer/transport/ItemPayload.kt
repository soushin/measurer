package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType

class ItemPayload(
    transactionId: String,
    itemName: String,
    trackingId: String,
    version: String = TransportConfig.VERSION
) : Payload() {
    init {
        this.trackingId = trackingId
        this.hit = HitType.Item
        this.protocolVersion = version
        this.transactionId = transactionId
        this.itemName = itemName
    }
}
