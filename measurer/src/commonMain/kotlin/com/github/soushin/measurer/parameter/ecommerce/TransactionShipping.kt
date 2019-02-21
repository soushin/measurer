package com.github.soushin.measurer.parameter.ecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object TransactionShipping : Parameter {
    override val name = "ts"
    override val type = Type.Double
    override val maxLength: Int? = null
}
