package com.github.soushin.measurer.parameter.ecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object TransactionAffiliation : Parameter {
    override val name = "ta"
    override val type = Type.String
    override val maxLength: Int? = 500
}
