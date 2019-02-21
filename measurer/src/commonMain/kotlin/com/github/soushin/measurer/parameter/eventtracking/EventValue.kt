package com.github.soushin.measurer.parameter.eventtracking

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object EventValue : Parameter {
    override val name = "ev"
    override val type = Type.Int
    override val maxLength: Int? = null
}
