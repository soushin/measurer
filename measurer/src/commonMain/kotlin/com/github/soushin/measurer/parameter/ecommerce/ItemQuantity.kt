package com.github.soushin.measurer.parameter.ecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ItemQuantity : Parameter {
    override val name = "iq"
    override val type = Type.Int
    override val maxLength: Int? = null
}
