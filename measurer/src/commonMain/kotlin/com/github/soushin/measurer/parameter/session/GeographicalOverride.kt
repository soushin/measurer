package com.github.soushin.measurer.parameter.session

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object GeographicalOverride : Parameter {
    override val name = "geoid"
    override val type = Type.String
    override val maxLength: Int? = null
}
