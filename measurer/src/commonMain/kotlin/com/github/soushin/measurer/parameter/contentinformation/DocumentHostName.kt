package com.github.soushin.measurer.parameter.contentinformation

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object DocumentHostName : Parameter {
    override val name = "dh"
    override val type = Type.String
    override val maxLength: Int? = 100
}
