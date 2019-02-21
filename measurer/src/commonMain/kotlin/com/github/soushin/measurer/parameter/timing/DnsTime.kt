package com.github.soushin.measurer.parameter.timing

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object DnsTime : Parameter {
    override val name = "dns"
    override val type = Type.Int
    override val maxLength: Int? = null
}
