package com.github.soushin.measurer.parameter.exceptions

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object IsExceptionFatal : Parameter {
    override val name = "exf"
    override val type = Type.Bool
    override val maxLength: Int? = null
}
