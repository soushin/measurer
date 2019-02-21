package com.github.soushin.measurer.parameter.contentinformation

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object LinkId : Parameter {
    override val name = "linkid"
    override val type = Type.String
    override val maxLength: Int? = null
}
