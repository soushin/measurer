package com.github.soushin.measurer.parameter.ecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object TransactionRevenue : Parameter {
    override val name = "tr"
    override val type = Type.Double
    override val maxLength: Int? = null
}
