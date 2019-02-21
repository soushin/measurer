package com.github.soushin.measurer.parameter.trafficsources

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object DocumentReferrer : Parameter {
    override val name = "dr"
    override val type = Type.String
    override val maxLength: Int? = 2048
}
