package com.github.soushin.measurer.parameter.systeminfo

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object FlashVersion : Parameter {
    override val name = "fl"
    override val type = Type.String
    override val maxLength: Int? = 20
}
