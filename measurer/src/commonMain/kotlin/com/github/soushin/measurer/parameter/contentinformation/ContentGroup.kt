package com.github.soushin.measurer.parameter.contentinformation

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

class ContentGroup(groupIndex: Int) : Parameter {
    override val name = "cd$groupIndex"
    override val type = Type.String
    override val maxLength: Int? = 100
}
