package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductImpressionVariant(listIndex: Int, productIndex: Int) : Parameter {
    override val name = "il${listIndex}pi${productIndex}va"
    override val type = Type.String
    override val maxLength: Int? = null
}
