package com.github.soushin.measurer.parameter.general

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object AnonymizeIp : Parameter {
    override val name = "aid"
    override val type = Type.Bool
    override val maxLength: Int? = null
}
