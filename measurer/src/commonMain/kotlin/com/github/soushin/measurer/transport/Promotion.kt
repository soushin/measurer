package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.enhancedecommerce.PromotionCreative
import com.github.soushin.measurer.parameter.enhancedecommerce.PromotionId
import com.github.soushin.measurer.parameter.enhancedecommerce.PromotionName
import com.github.soushin.measurer.parameter.enhancedecommerce.PromotionPosition

class Promotion(val index: Int) {

    var id: String? = null
        set(value) = setParam(PromotionId(index), value) { field = it }
    var name: String? = null
        set(value) = setParam(PromotionName(index), value) { field = it }
    var creative: String? = null
        set(value) = setParam(PromotionCreative(index), value) { field = it }
    var position: String? = null
        set(value) = setParam(PromotionPosition(index), value) { field = it }

    val params: MutableMap<Parameter, String> = mutableMapOf()

    private fun <T : Any> setParam(parameter: Parameter, value: T?, setFiledFunc: (T) -> Unit) {
        value?.also {
            Payload.validType(parameter, value)
            params[parameter] = value.toString()
            setFiledFunc(value)
        } ?: params.remove(parameter)
    }
}
