package com.github.soushin.measurer.parameter.socialinteractions

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object SocialAction : Parameter {
    override val name = "sa"
    override val type = Type.String
    override val maxLength: Int? = 50
}
