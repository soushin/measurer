package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductImpressionCustomMetric(listIndex: Int, productIndex: Int, metricIndex: Int) : Parameter {
    override val name = "il${listIndex}pi${productIndex}cm$metricIndex"
    override val type = Type.Int
    override val maxLength: Int? = null
}
