package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ProductCustomMetric(productIndex: Int, metricIndex: Int) : Parameter {
    override val name = "pr${productIndex}cm$metricIndex"
    override val type = Type.Int
    override val maxLength: Int? = null
}
