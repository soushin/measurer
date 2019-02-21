package com.github.soushin.measurer.parameter.user

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object UserId : Parameter {
    override val name = "uid"
    override val type = Type.String
    override val maxLength: Int? = null
}
