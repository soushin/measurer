package com.github.soushin.measurer.parameter.contentinformation

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object DocumentTitle : Parameter {
    override val name = "dt"
    override val type = Type.String
    override val maxLength: Int? = 1500
}
