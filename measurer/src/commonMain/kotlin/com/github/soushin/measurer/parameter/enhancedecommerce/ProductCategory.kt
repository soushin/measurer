package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductCategory(productIndex: Int) : Parameter {
    override val name = "pr${productIndex}ca"
    override val type = Type.String
    override val maxLength: Int? = 500
}
