package com.github.soushin.measurer.parameter.trafficsources

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object CampaignSource : Parameter {
    override val name = "cs"
    override val type = Type.String
    override val maxLength: Int? = 100
}
