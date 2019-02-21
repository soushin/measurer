package com.github.soushin.measurer.parameter.enhancedecommerce

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object Tax : Parameter {
    override val name = "tt"
    override val type = Type.Double
    override val maxLength: Int? = null
}
