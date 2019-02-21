package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductCustomDimension(productIndex: Int, dimensionIndex: Int) : Parameter {
    override val name = "pr${productIndex}cd$dimensionIndex"
    override val type = Type.String
    override val maxLength: Int? = 150
}
