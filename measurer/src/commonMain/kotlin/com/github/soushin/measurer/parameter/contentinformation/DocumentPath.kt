package com.github.soushin.measurer.parameter.contentinformation

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object DocumentPath : Parameter {
    override val name = "dp"
    override val type = Type.String
    override val maxLength: Int? = 2048
}
