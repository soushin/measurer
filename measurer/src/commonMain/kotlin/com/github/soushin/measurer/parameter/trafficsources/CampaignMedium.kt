package com.github.soushin.measurer.parameter.trafficsources

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object CampaignMedium : Parameter {
    override val name = "cm"
    override val type = Type.String
    override val maxLength: Int? = 50
}
