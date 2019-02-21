package com.github.soushin.measurer.parameter.systeminfo

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ScreenColors : Parameter {
    override val name = "sd"
    override val type = Type.String
    override val maxLength: Int? = 20
}
