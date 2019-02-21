package com.github.soushin.measurer.parameter.trafficsources

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type

object CampaignKeyword : Parameter {
    override val name = "ck"
    override val type = Type.String
    override val maxLength: Int? = 500
}
