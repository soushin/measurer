package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object CurrencyCode : Parameter {
    override val name = "cu"
    override val type = Type.String
    override val maxLength: Int? = 10
}
