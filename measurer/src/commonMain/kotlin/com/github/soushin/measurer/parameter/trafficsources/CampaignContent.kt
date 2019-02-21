package com.github.soushin.measurer.parameter.trafficsources

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object CampaignContent : Parameter {
    override val name = "cc"
    override val type = Type.String
    override val maxLength: Int? = 500
}
