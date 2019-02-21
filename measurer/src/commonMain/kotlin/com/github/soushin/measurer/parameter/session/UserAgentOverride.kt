package com.github.soushin.measurer.parameter.session

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object UserAgentOverride : Parameter {
    override val name = "ua"
    override val type = Type.String
    override val maxLength: Int? = null
}
