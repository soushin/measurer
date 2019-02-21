package com.github.soushin.measurer.parameter.exceptions

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ExceptionDescription : Parameter {
    override val name = "exd"
    override val type = Type.String
    override val maxLength: Int? = 150
}
