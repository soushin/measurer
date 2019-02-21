package com.github.soushin.measurer.parameter.general

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object CacheBuster : Parameter {
    override val name = "z"
    override val type = Type.Bool
    override val maxLength: Int? = null
}
