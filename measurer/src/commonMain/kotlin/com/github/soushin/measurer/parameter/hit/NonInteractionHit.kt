package com.github.soushin.measurer.parameter.hit

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object NonInteractionHit : Parameter {
    override val name = "ni"
    override val type = Type.Bool
    override val maxLength: Int? = null
}
