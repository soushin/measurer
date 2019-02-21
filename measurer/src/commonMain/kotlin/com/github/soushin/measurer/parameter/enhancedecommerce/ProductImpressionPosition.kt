package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductImpressionPosition(listIndex: Int, productIndex: Int) : Parameter {
    override val name = "il${listIndex}pi${productIndex}ps"
    override val type = Type.Int
    override val maxLength: Int? = null
}
