package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class PromotionCreative(promoIndex: Int) : Parameter {
    override val name = "promo${promoIndex}cr"
    override val type = Type.String
    override val maxLength: Int? = null
}
