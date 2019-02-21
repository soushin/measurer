package com.github.soushin.measurer.parameter.apptracking

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object ApplicationInstallerId : Parameter {
    override val name = "aiid"
    override val type = Type.String
    override val maxLength: Int? = 150
}
