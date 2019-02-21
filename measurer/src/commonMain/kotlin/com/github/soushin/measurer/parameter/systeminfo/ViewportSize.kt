package com.github.soushin.measurer.parameter.systeminfo

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ViewportSize : Parameter {
    override val name = "vp"
    override val type = Type.String
    override val maxLength: Int? = 20
}
