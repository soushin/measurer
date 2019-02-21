package com.github.soushin.measurer.parameter.timing

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object UserTimingVariableName : Parameter {
    override val name = "utv"
    override val type = Type.String
    override val maxLength: Int? = 500
}
