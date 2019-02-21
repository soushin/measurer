package com.github.soushin.measurer.parameter.ecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ItemName : Parameter {
    override val name = "in"
    override val type = Type.String
    override val maxLength: Int? = 500
}
