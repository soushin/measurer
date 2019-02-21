package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class PromotionId(promoIndex: Int) : Parameter {
    override val name = "promo${promoIndex}id"
    override val type = Type.String
    override val maxLength: Int? = null
}
