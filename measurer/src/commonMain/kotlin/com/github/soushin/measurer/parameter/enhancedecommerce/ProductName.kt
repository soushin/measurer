package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductName(productIndex: Int) : Parameter {
    override val name = "pr${productIndex}nm"
    override val type = Type.String
    override val maxLength: Int? = 500
}
