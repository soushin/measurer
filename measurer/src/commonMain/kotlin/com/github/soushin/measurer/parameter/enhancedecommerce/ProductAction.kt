package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ProductAction : Parameter {
    override val name = "pa"
    override val type = Type.String
    override val maxLength: Int? = null
}
