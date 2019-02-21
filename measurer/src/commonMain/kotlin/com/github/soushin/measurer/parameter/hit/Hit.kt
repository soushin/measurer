package com.github.soushin.measurer.parameter.hit

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object Hit : Parameter {
    override val name = "t"
    override val type = Type.Hit
    override val maxLength: Int? = null
}
