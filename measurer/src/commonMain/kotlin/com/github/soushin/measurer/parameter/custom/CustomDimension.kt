package com.github.soushin.measurer.parameter.custom

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class CustomDimension(dimensionIndex: Int) : Parameter {
    override val name = "cd$dimensionIndex"
    override val type = Type.String
    override val maxLength: Int? = 150
}
