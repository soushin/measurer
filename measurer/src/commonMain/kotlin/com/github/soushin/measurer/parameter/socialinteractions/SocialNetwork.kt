package com.github.soushin.measurer.parameter.socialinteractions

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object SocialNetwork : Parameter {
    override val name = "sn"
    override val type = Type.String
    override val maxLength: Int? = 50
}
