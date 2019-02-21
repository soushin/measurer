package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductImpressionCustomDimension(listIndex: Int, productIndex: Int, dimensionIndex: Int) : Parameter {
    override val name = "il${listIndex}pi${productIndex}cd$dimensionIndex"
    override val type = Type.String
    override val maxLength: Int? = null
}
