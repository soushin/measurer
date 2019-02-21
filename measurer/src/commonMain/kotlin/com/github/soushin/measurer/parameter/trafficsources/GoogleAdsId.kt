package com.github.soushin.measurer.parameter.trafficsources

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object GoogleAdsId : Parameter {
    override val name = "gclid"
    override val type = Type.String
    override val maxLength: Int? = null
}
