package com.github.soushin.measurer.parameter.ecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object TransactionId : Parameter {
    override val name = "ti"
    override val type = Type.String
    override val maxLength: Int? = 500
}
