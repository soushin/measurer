package com.github.soushin.measurer.parameter.eventtracking

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object EventCategory : Parameter {
    override val name = "ec"
    override val type = Type.String
    override val maxLength: Int? = 150
}
