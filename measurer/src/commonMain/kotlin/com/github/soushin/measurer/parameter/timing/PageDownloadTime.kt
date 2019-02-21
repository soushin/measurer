package com.github.soushin.measurer.parameter.timing

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object PageDownloadTime : Parameter {
    override val name = "pdt"
    override val type = Type.Int
    override val maxLength: Int? = null
}
