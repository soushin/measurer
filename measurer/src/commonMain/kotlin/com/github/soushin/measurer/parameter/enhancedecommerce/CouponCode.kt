package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object CouponCode : Parameter {
    override val name = "tcc"
    override val type = Type.String
    override val maxLength: Int? = null
}
