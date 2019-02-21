package com.github.soushin.measurer.parameter.systeminfo

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object UserLanguage : Parameter {
    override val name = "ul"
    override val type = Type.String
    override val maxLength: Int? = 20
}
