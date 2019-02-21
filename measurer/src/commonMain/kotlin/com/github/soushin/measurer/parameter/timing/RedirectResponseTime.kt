package com.github.soushin.measurer.parameter.timing

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object RedirectResponseTime : Parameter {
    override val name = "rrt"
    override val type = Type.Int
    override val maxLength: Int? = null
}
