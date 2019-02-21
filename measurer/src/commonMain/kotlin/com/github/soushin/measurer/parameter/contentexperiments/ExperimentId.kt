package com.github.soushin.measurer.parameter.contentexperiments

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ExperimentId : Parameter {
    override val name = "xid"
    override val type = Type.String
    override val maxLength: Int? = 40
}
