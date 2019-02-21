package com.github.soushin.measurer.parameter.eventtracking

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object EventAction : Parameter {
    override val name = "ea"
    override val type = Type.String
    override val maxLength: Int? = 500
}
