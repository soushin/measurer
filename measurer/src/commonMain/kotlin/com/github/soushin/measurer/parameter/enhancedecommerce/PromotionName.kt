package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class PromotionName(promoIndex: Int) : Parameter {
    override val name = "promo${promoIndex}nm"
    override val type = Type.String
    override val maxLength: Int? = null
}
