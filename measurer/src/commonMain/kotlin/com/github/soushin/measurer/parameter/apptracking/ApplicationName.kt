package com.github.soushin.measurer.parameter.apptracking

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ApplicationName : Parameter {
    override val name = "an"
    override val type = Type.String
    override val maxLength: Int? = 100
}
