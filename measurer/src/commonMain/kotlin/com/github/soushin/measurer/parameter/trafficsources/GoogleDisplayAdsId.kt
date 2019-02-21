package com.github.soushin.measurer.parameter.trafficsources

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object GoogleDisplayAdsId : Parameter {
    override val name = "dclid"
    override val type = Type.String
    override val maxLength: Int? = null
}
