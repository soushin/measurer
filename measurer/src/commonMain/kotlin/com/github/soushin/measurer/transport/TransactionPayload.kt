package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType

class TransactionPayload(
    transactionId: String,
    trackingId: String,
    version: String = TransportConfig.VERSION
) : Payload() {
    init {
        this.trackingId = trackingId
        this.hit = HitType.Transaction
        this.protocolVersion = version
        this.transactionId = transactionId
    }
}
