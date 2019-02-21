package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductQuantity(productIndex: Int) : Parameter {
    override val name = "pr${productIndex}qt"
    override val type = Type.Int
    override val maxLength: Int? = null
}
