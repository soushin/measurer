package com.github.soushin.measurer.parameter.apptracking

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ApplicationId : Parameter {
    override val name = "aid"
    override val type = Type.String
    override val maxLength: Int? = 150
}
