package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductImpressionBrand(listIndex: Int, productIndex: Int) : Parameter {
    override val name = "il${listIndex}pi${productIndex}br"
    override val type = Type.String
    override val maxLength: Int? = null
}
