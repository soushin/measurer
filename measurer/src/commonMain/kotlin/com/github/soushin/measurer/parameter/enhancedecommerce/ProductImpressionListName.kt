package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductImpressionListName(listIndex: Int) : Parameter {
    override val name = "il${listIndex}nm"
    override val type = Type.String
    override val maxLength: Int? = null
}
