package com.github.soushin.measurer.parameter.timing

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object DomInteractiveTime : Parameter {
    override val name = "dit"
    override val type = Type.Int
    override val maxLength: Int? = null
}
