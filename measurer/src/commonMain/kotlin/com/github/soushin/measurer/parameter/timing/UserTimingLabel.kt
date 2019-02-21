package com.github.soushin.measurer.parameter.timing

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object UserTimingLabel : Parameter {
    override val name = "utl"
    override val type = Type.String
    override val maxLength: Int? = 500
}
