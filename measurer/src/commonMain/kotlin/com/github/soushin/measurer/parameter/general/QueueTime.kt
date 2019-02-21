package com.github.soushin.measurer.parameter.general

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object QueueTime : Parameter {
    override val name = "qt"
    override val type = Type.Int
    override val maxLength: Int? = null
}
