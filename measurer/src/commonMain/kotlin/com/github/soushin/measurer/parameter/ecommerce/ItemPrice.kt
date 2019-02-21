package com.github.soushin.measurer.parameter.ecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ItemPrice : Parameter {
    override val name = "ip"
    override val type = Type.Double
    override val maxLength: Int? = null
}
