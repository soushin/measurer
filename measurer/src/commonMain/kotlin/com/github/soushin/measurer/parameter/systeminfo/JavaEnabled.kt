package com.github.soushin.measurer.parameter.systeminfo

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object JavaEnabled : Parameter {
    override val name = "je"
    override val type = Type.Bool
    override val maxLength: Int? = null
}
