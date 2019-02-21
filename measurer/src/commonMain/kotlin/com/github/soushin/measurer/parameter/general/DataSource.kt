package com.github.soushin.measurer.parameter.general

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object DataSource : Parameter {
    override val name = "ds"
    override val type = Type.String
    override val maxLength: Int? = null
}