package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductBrand
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductCategory
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductCouponCode
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductCustomDimension
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductCustomMetric
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductName
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductPosition
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductPrice
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductQuantity
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductSku
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductVariant

class Product(val index: Int) {

    var sku: String? = null
        set(value) = setParam(ProductSku(index), value) { field = it }
    var name: String? = null
        set(value) = setParam(ProductName(index), value) { field = it }
    var brand: String? = null
        set(value) = setParam(ProductBrand(index), value) { field = it }
    var category: String? = null
        set(value) = setParam(ProductCategory(index), value) { field = it }
    var variant: String? = null
        set(value) = setParam(ProductVariant(index), value) { field = it }
    var price: Double? = null
        set(value) = setParam(ProductPrice(index), value) { field = it }
    var quantity: Int? = null
        set(value) = setParam(ProductQuantity(index), value) { field = it }
    var couponCode: String? = null
        set(value) = setParam(ProductCouponCode(index), value) { field = it }
    var position: Int? = null
        set(value) = setParam(ProductPosition(index), value) { field = it }
    var customDimension: Pair<Int, String>? = null
        set(value) = setCustomDimension(value, { ProductCustomDimension(index, it) }) { field = it }
    var customMetrics: Pair<Int, Int>? = null
        set(value) = setCustomMetrics(value, { ProductCustomMetric(index, it) }) { field = it }

    val params: MutableMap<Parameter, String> = mutableMapOf()
    val customDimensions: MutableMap<Int, Pair<ProductCustomDimension, String>> = mutableMapOf()
    val customMercies: MutableMap<Int, Pair<ProductCustomMetric, Int>> = mutableMapOf()

    private fun <T : Any> setParam(parameter: Parameter, value: T?, setFiledFunc: (T) -> Unit) {
        value?.also {
            Payload.validType(parameter, value)
            params[parameter] = value.toString()
            setFiledFunc(value)
        } ?: params.remove(parameter)
    }

    private fun setCustomDimension(
        value: Pair<Int, String>?,
        fixIndexFunc: (Int) -> ProductCustomDimension,
        setFiledFunc: (Pair<Int, String>?) -> Unit
    ) {
        value?.first?.let {
            Payload.validType(ProductCustomDimension(index, value.first), value.second)
            customDimensions.put(value.first, fixIndexFunc(it) to value.second)
        }
        setFiledFunc(value)
    }

    private fun setCustomMetrics(
        value: Pair<Int, Int>?,
        fixIndexFunc: (Int) -> ProductCustomMetric,
        setFiledFunc: (Pair<Int, Int>?) -> Unit
    ) {
        value?.first?.let {
            Payload.validType(ProductCustomMetric(index, value.first), value.second)
            customMercies.put(value.first, fixIndexFunc(it) to value.second)
        }
        setFiledFunc(value)
    }
}

