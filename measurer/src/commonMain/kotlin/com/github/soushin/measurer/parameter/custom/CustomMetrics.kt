package com.github.soushin.measurer.parameter.custom

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class CustomMetrics(dimensionIndex: Int) : Parameter {
    override val name = "cm$dimensionIndex"
    override val type = Type.Int
    override val maxLength: Int? = null
}
