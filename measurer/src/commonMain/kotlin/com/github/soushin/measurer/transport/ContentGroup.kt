package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.contentinformation.ContentGroup

class ContentGroup(val index: Int) {

    var value: String? = null
        set(value) = setParam(ContentGroup(index), value) { field = it }

    val params: MutableMap<Parameter, String> = mutableMapOf()

    private fun <T : Any> setParam(parameter: Parameter, value: T?, setFiledFunc: (T) -> Unit) {
        value?.also {
            Payload.validType(parameter, value)
            params[parameter] = value.toString()
            setFiledFunc(value)
        } ?: params.remove(parameter)
    }
}
