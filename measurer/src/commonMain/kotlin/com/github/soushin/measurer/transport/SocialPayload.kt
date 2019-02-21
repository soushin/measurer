package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType

class SocialPayload(
    socialNetwork: String,
    socialAction: String,
    socialActionTarget: String,
    trackingId: String,
    version: String = TransportConfig.VERSION
) : Payload() {
    init {
        this.trackingId = trackingId
        this.hit = HitType.Social
        this.protocolVersion = version
        this.socialNetwork = socialNetwork
        this.socialAction = socialAction
        this.socialActionTarget = socialActionTarget
    }
}
