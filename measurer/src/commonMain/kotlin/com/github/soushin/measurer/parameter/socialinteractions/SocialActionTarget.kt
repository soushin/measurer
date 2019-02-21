package com.github.soushin.measurer.parameter.socialinteractions

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object SocialActionTarget : Parameter {
    override val name = "st"
    override val type = Type.String
    override val maxLength: Int? = 2048
}
