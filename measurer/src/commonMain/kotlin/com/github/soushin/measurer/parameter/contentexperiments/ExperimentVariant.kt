package com.github.soushin.measurer.parameter.contentexperiments

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ExperimentVariant : Parameter {
    override val name = "xvar"
    override val type = Type.String
    override val maxLength: Int? = null
}
