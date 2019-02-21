package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductPosition(productIndex: Int) : Parameter {
    override val name = "pr${productIndex}ps"
    override val type = Type.Int
    override val maxLength: Int? = null
}
