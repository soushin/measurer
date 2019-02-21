package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductPrice(productIndex: Int) : Parameter {
    override val name = "pr${productIndex}pr"
    override val type = Type.Double
    override val maxLength: Int? = null
}
