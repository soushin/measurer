package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionBrand
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionCategory
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionCustomDimension
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionCustomMetric
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionListName
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionName
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionPosition
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionPrice
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionSku
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductImpressionVariant

class ProductImpressions(val listIndex: Int) {

    var listName: String? = null
        set(value) = setParam(ProductImpressionListName(listIndex), value) { field = it }
    var product: Product? = null
        set(value) {
            value?.let {
                products.put(value.index, value)
            }
            field = value
        }

    val params: MutableMap<Parameter, String> = mutableMapOf()

    val products: MutableMap<Int, Product> = mutableMapOf()

    private fun <T : Any> setParam(parameter: Parameter, value: T?, setFiledFunc: (T) -> Unit) {
        value?.also {
            Payload.validType(parameter, value)
            params.put(parameter, value.toString())
            setFiledFunc(value)
        } ?: params.remove(parameter)
    }

    class Product(val listIndex: Int, val index: Int) {

        var sku: String? = null
            set(value) = setParam(ProductImpressionSku(listIndex, index), value) { field = it }
        var name: String? = null
            set(value) = setParam(ProductImpressionName(listIndex, index), value) { field = it }
        var brand: String? = null
            set(value) = setParam(ProductImpressionBrand(listIndex, index), value) { field = it }
        var category: String? = null
            set(value) = setParam(ProductImpressionCategory(listIndex, index), value) { field = it }
        var variant: String? = null
            set(value) = setParam(ProductImpressionVariant(listIndex, index), value) { field = it }
        var price: Double? = null
            set(value) = setParam(ProductImpressionPrice(listIndex, index), value) { field = it }
        var position: Int? = null
            set(value) = setParam(ProductImpressionPosition(listIndex, index), value) { field = it }
        var customDimension: Pair<Int, String>? = null
            set(value) = setCustomDimension(
                value, { _, _, id -> ProductImpressionCustomDimension(listIndex, index, id) }) {
                field = it
            }
        var customMetrics: Pair<Int, Int>? = null
            set(value) = setCustomMetrics(
                value, { _, _, id -> ProductImpressionCustomMetric(listIndex, index, id) }) {
                field = it
            }

        val params: MutableMap<Parameter, String> = mutableMapOf()
        val customDimensions: MutableMap<Int, Pair<ProductImpressionCustomDimension, String>> = mutableMapOf()
        val customMercies: MutableMap<Int, Pair<ProductImpressionCustomMetric, Int>> = mutableMapOf()

        private fun <T : Any> setParam(parameter: Parameter, value: T?, setFiledFunc: (T) -> Unit) {
            value?.also {
                Payload.validType(parameter, value)
                params[parameter] = value.toString()
                setFiledFunc(value)
            } ?: params.remove(parameter)
        }

        private fun setCustomDimension(
            value: Pair<Int, String>?,
            fixIndexFunc: (Int, Int, Int) -> ProductImpressionCustomDimension,
            setFiledFunc: (Pair<Int, String>?) -> Unit
        ) {
            value?.first?.let {
                Payload.validType(ProductImpressionCustomDimension(listIndex, index, value.first), value.second)
                customDimensions.put(value.first, fixIndexFunc(listIndex, index, it) to value.second)
            }
            setFiledFunc(value)
        }

        private fun setCustomMetrics(
            value: Pair<Int, Int>?,
            fixIndexFunc: (Int, Int, Int) -> ProductImpressionCustomMetric,
            setFiledFunc: (Pair<Int, Int>?) -> Unit
        ) {
            value?.first?.let {
                Payload.validType(ProductImpressionCustomMetric(listIndex, index, value.first), value.second)
                customMercies.put(value.first, fixIndexFunc(listIndex, index, it) to value.second)
            }
            setFiledFunc(value)
        }
    }
}
