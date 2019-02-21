package com.github.soushin.measurer.parameter.trafficsources

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object CampaignName : Parameter {
    override val name = "cn"
    override val type = Type.String
    override val maxLength: Int? = 100
}
