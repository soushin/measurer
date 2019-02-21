package com.github.soushin.measurer.parameter.timing

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object UserTimingCategory : Parameter {
    override val name = "utc"
    override val type = Type.String
    override val maxLength: Int? = 150
}
