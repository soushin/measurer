package com.github.soushin.measurer.transport

import com.github.soushin.measurer.parameter.HitType
import com.github.soushin.measurer.parameter.Parameter
import com.github.soushin.measurer.parameter.Type
import com.github.soushin.measurer.parameter.apptracking.ApplicationId
import com.github.soushin.measurer.parameter.apptracking.ApplicationInstallerId
import com.github.soushin.measurer.parameter.apptracking.ApplicationName
import com.github.soushin.measurer.parameter.apptracking.ApplicationVersion
import com.github.soushin.measurer.parameter.contentexperiments.ExperimentId
import com.github.soushin.measurer.parameter.contentexperiments.ExperimentVariant
import com.github.soushin.measurer.parameter.contentinformation.DocumentHostName
import com.github.soushin.measurer.parameter.contentinformation.DocumentLocationUrl
import com.github.soushin.measurer.parameter.contentinformation.DocumentPath
import com.github.soushin.measurer.parameter.contentinformation.DocumentTitle
import com.github.soushin.measurer.parameter.contentinformation.LinkId
import com.github.soushin.measurer.parameter.contentinformation.ScreenName
import com.github.soushin.measurer.parameter.custom.CustomDimension
import com.github.soushin.measurer.parameter.custom.CustomMetrics
import com.github.soushin.measurer.parameter.ecommerce.ItemCategory
import com.github.soushin.measurer.parameter.ecommerce.ItemCode
import com.github.soushin.measurer.parameter.ecommerce.ItemName
import com.github.soushin.measurer.parameter.ecommerce.ItemPrice
import com.github.soushin.measurer.parameter.ecommerce.ItemQuantity
import com.github.soushin.measurer.parameter.ecommerce.TransactionAffiliation
import com.github.soushin.measurer.parameter.ecommerce.TransactionId
import com.github.soushin.measurer.parameter.ecommerce.TransactionRevenue
import com.github.soushin.measurer.parameter.ecommerce.TransactionShipping
import com.github.soushin.measurer.parameter.ecommerce.TransactionTax
import com.github.soushin.measurer.parameter.enhancedecommerce.Affiliation
import com.github.soushin.measurer.parameter.enhancedecommerce.CheckoutStep
import com.github.soushin.measurer.parameter.enhancedecommerce.CheckoutStepOption
import com.github.soushin.measurer.parameter.enhancedecommerce.CouponCode
import com.github.soushin.measurer.parameter.enhancedecommerce.CurrencyCode
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductAction
import com.github.soushin.measurer.parameter.enhancedecommerce.ProductActionList
import com.github.soushin.measurer.parameter.enhancedecommerce.PromotionAction
import com.github.soushin.measurer.parameter.enhancedecommerce.Revenue
import com.github.soushin.measurer.parameter.enhancedecommerce.Shipping
import com.github.soushin.measurer.parameter.enhancedecommerce.Tax
import com.github.soushin.measurer.parameter.eventtracking.EventAction
import com.github.soushin.measurer.parameter.eventtracking.EventCategory
import com.github.soushin.measurer.parameter.eventtracking.EventLabel
import com.github.soushin.measurer.parameter.eventtracking.EventValue
import com.github.soushin.measurer.parameter.exceptions.ExceptionDescription
import com.github.soushin.measurer.parameter.exceptions.IsExceptionFatal
import com.github.soushin.measurer.parameter.general.AnonymizeIp
import com.github.soushin.measurer.parameter.general.CacheBuster
import com.github.soushin.measurer.parameter.general.DataSource
import com.github.soushin.measurer.parameter.general.ProtocolVersion
import com.github.soushin.measurer.parameter.general.QueueTime
import com.github.soushin.measurer.parameter.general.TrackingId
import com.github.soushin.measurer.parameter.hit.Hit
import com.github.soushin.measurer.parameter.hit.NonInteractionHit
import com.github.soushin.measurer.parameter.session.GeographicalOverride
import com.github.soushin.measurer.parameter.session.IpOverride
import com.github.soushin.measurer.parameter.session.SessionControl
import com.github.soushin.measurer.parameter.session.UserAgentOverride
import com.github.soushin.measurer.parameter.socialinteractions.SocialAction
import com.github.soushin.measurer.parameter.socialinteractions.SocialActionTarget
import com.github.soushin.measurer.parameter.socialinteractions.SocialNetwork
import com.github.soushin.measurer.parameter.systeminfo.DocumentEncoding
import com.github.soushin.measurer.parameter.systeminfo.FlashVersion
import com.github.soushin.measurer.parameter.systeminfo.JavaEnabled
import com.github.soushin.measurer.parameter.systeminfo.ScreenColors
import com.github.soushin.measurer.parameter.systeminfo.ScreenResolution
import com.github.soushin.measurer.parameter.systeminfo.UserLanguage
import com.github.soushin.measurer.parameter.systeminfo.ViewportSize
import com.github.soushin.measurer.parameter.timing.ContentLoadTime
import com.github.soushin.measurer.parameter.timing.DnsTime
import com.github.soushin.measurer.parameter.timing.DomInteractiveTime
import com.github.soushin.measurer.parameter.timing.PageDownloadTime
import com.github.soushin.measurer.parameter.timing.PageLoadTime
import com.github.soushin.measurer.parameter.timing.RedirectResponseTime
import com.github.soushin.measurer.parameter.timing.ServerResponseTime
import com.github.soushin.measurer.parameter.timing.TcpConnectTime
import com.github.soushin.measurer.parameter.timing.UserTimingCategory
import com.github.soushin.measurer.parameter.timing.UserTimingLabel
import com.github.soushin.measurer.parameter.timing.UserTimingTime
import com.github.soushin.measurer.parameter.timing.UserTimingVariableName
import com.github.soushin.measurer.parameter.trafficsources.CampaignContent
import com.github.soushin.measurer.parameter.trafficsources.CampaignId
import com.github.soushin.measurer.parameter.trafficsources.CampaignKeyword
import com.github.soushin.measurer.parameter.trafficsources.CampaignMedium
import com.github.soushin.measurer.parameter.trafficsources.CampaignName
import com.github.soushin.measurer.parameter.trafficsources.CampaignSource
import com.github.soushin.measurer.parameter.trafficsources.DocumentReferrer
import com.github.soushin.measurer.parameter.trafficsources.GoogleAdsId
import com.github.soushin.measurer.parameter.trafficsources.GoogleDisplayAdsId
import com.github.soushin.measurer.parameter.user.ClientId
import com.github.soushin.measurer.parameter.user.UserId

abstract class Payload {

    companion object {
        fun validType(parameter: Parameter, value: Any) {
            if (!parameter.type.validType(value))
                throw IllegalArgumentException("invalid parameter type: name=${parameter.name}, type=${parameter.type}, val=$value")
            parameter.maxLength?.takeIf { parameter.type == Type.String && it < value.toString().length }?.let {
                throw IllegalArgumentException("invalid parameter size: name=${parameter.name}, type=${parameter.type}, val=$value")
            }
        }
    }

    // general
    var trackingId: String? = null
        set(value) = setProperty(value, TrackingId) { field = it }
    var protocolVersion: String? = null
        set(value) = setProperty(value, ProtocolVersion) { field = it }
    var anonymizeIp: String? = null
        set(value) = setProperty(value, AnonymizeIp) { field = it }
    var dataSource: String? = null
        set(value) = setProperty(value, DataSource) { field = it }
    var queueTime: String? = null
        set(value) = setProperty(value, QueueTime) { field = it }
    var cacheBuster: String? = null
        set(value) = setProperty(value, CacheBuster) { field = it }

    // user
    var clientId: String? = null
        set(value) = setProperty(value, ClientId) { field = it }
    var userId: String? = null
        set(value) = setProperty(value, UserId) { field = it }

    // session
    var sessionControl: String? = null
        set(value) = setProperty(value, SessionControl) { field = it }
    var ipOverride: String? = null
        set(value) = setProperty(value, IpOverride) { field = it }
    var userAgentOverride: String? = null
        set(value) = setProperty(value, UserAgentOverride) { field = it }
    var geographicalOverride: String? = null
        set(value) = setProperty(value, GeographicalOverride) { field = it }

    // traffic sources
    var documentReferrer: String? = null
        set(value) = setProperty(value, DocumentReferrer) { field = it }
    var campaignName: String? = null
        set(value) = setProperty(value, CampaignName) { field = it }
    var campaignSource: String? = null
        set(value) = setProperty(value, CampaignSource) { field = it }
    var campaignMedium: String? = null
        set(value) = setProperty(value, CampaignMedium) { field = it }
    var campaignKeyword: String? = null
        set(value) = setProperty(value, CampaignKeyword) { field = it }
    var campaignContent: String? = null
        set(value) = setProperty(value, CampaignContent) { field = it }
    var campaignId: String? = null
        set(value) = setProperty(value, CampaignId) { field = it }
    var googleAdsId: String? = null
        set(value) = setProperty(value, GoogleAdsId) { field = it }
    var googleDisplayAdsId: String? = null
        set(value) = setProperty(value, GoogleDisplayAdsId) { field = it }

    // system info
    var screenResolution: String? = null
        set(value) = setProperty(value, ScreenResolution) { field = it }
    var viewportSize: String? = null
        set(value) = setProperty(value, ViewportSize) { field = it }
    var documentEncoding: String? = null
        set(value) = setProperty(value, DocumentEncoding) { field = it }
    var screenColors: String? = null
        set(value) = setProperty(value, ScreenColors) { field = it }
    var userLanguage: String? = null
        set(value) = setProperty(value, UserLanguage) { field = it }
    var javaEnabled: Boolean? = null
        set(value) = setProperty(value, JavaEnabled) { field = it }
    var flashVersion: String? = null
        set(value) = setProperty(value, FlashVersion) { field = it }

    // hit
    var hit: HitType? = null
        set(value) = setProperty(value, Hit) { field = it }
    var nonInteractionHit: Boolean? = null
        set(value) = setProperty(value, NonInteractionHit) { field = it }

    // content information
    var documentLocationUrl: String? = null
        set(value) = setProperty(value, DocumentLocationUrl) { field = it }
    var documentHostName: String? = null
        set(value) = setProperty(value, DocumentHostName) { field = it }
    var documentPath: String? = null
        set(value) = setProperty(value, DocumentPath) { field = it }
    var documentTitle: String? = null
        set(value) = setProperty(value, DocumentTitle) { field = it }
    var screenName: String? = null
        set(value) = setProperty(value, ScreenName) { field = it }
    var contentGroup: ContentGroup? = null
        set(value) {
            value?.let {
                contentGroups[it.index]?.also {
                    contentGroups[it.index] = it
                } ?: contentGroups.put(it.index, it)
            }
            field = value
        }
    var linkId: String? = null
        set(value) = setProperty(value, LinkId) { field = it }

    // app tracking
    var applicationName: String? = null
        set(value) = setProperty(value, ApplicationName) { field = it }
    var applicationId: String? = null
        set(value) = setProperty(value, ApplicationId) { field = it }
    var applicationVersion: String? = null
        set(value) = setProperty(value, ApplicationVersion) { field = it }
    var applicationInstallerId: String? = null
        set(value) = setProperty(value, ApplicationInstallerId) { field = it }

    // event tracking
    var eventCategory: String? = null
        set(value) = setProperty(value, EventCategory) { field = it }
    var eventAction: String? = null
        set(value) = setProperty(value, EventAction) { field = it }
    var eventLabel: String? = null
        set(value) = setProperty(value, EventLabel) { field = it }
    var eventValue: Int? = null
        set(value) = setProperty(value, EventValue) { field = it }

    // e commerce
    var transactionId: String? = null
        set(value) = setProperty(value, TransactionId) { field = it }
    var transactionAffiliation: String? = null
        set(value) = setProperty(value, TransactionAffiliation) { field = it }
    var transactionRevenue: Double? = null
        set(value) = setProperty(value, TransactionRevenue) { field = it }
    var transactionShipping: Double? = null
        set(value) = setProperty(value, TransactionShipping) { field = it }
    var transactionTax: Double? = null
        set(value) = setProperty(value, TransactionTax) { field = it }
    var itemName: String? = null
        set(value) = setProperty(value, ItemName) { field = it }
    var itemPrice: Double? = null
        set(value) = setProperty(value, ItemPrice) { field = it }
    var itemQuantity: Int? = null
        set(value) = setProperty(value, ItemQuantity) { field = it }
    var itemCode: String? = null
        set(value) = setProperty(value, ItemCode) { field = it }
    var itemCategory: String? = null
        set(value) = setProperty(value, ItemCategory) { field = it }

    // enhanced e commerce
    var product: Product? = null
        set(value) {
            value?.let { prd ->
                products[prd.index]?.also {
                    products[prd.index] = it
                } ?: products.put(prd.index, prd)
            }
            field = value
        }
    var productAction: String? = null
        set(value) = setProperty(value, ProductAction) { field = it }
    var affiliation: String? = null
        set(value) = setProperty(value, Affiliation) { field = it }
    var revenue: Double? = null
        set(value) = setProperty(value, Revenue) { field = it }
    var tax: Double? = null
        set(value) = setProperty(value, Tax) { field = it }
    var shipping: Double? = null
        set(value) = setProperty(value, Shipping) { field = it }
    var couponCode: String? = null
        set(value) = setProperty(value, CouponCode) { field = it }
    var productActionList: String? = null
        set(value) = setProperty(value, ProductActionList) { field = it }
    var checkoutStep: Int? = null
        set(value) = setProperty(value, CheckoutStep) { field = it }
    var checkoutStepOption: String? = null
        set(value) = setProperty(value, CheckoutStepOption) { field = it }
    var productImpression: ProductImpressions? = null
        set(value) {
            value?.let { prdImp ->
                productImpressions[prdImp.listIndex]?.also {
                    productImpressions[prdImp.listIndex] = it.apply { add(prdImp) }
                } ?: productImpressions.put(prdImp.listIndex, mutableListOf(prdImp))
            }
            field = value
        }
    var promotion: Promotion? = null
        set(value) {
            value?.let { promo ->
                promotions[promo.index]?.also {
                    promotions[promo.index] = it
                } ?: promotions.put(promo.index, promo)
            }
            field = value
        }
    var promotionAction: String? = null
        set(value) = setProperty(value, PromotionAction) { field = it }
    var currencyCode: String? = null
        set(value) = setProperty(value, CurrencyCode) { field = it }

    // social interactions
    var socialNetwork: String? = null
        set(value) = setProperty(value, SocialNetwork) { field = it }
    var socialAction: String? = null
        set(value) = setProperty(value, SocialAction) { field = it }
    var socialActionTarget: String? = null
        set(value) = setProperty(value, SocialActionTarget) { field = it }

    // timing
    var userTimingCategory: String? = null
        set(value) = setProperty(value, UserTimingCategory) { field = it }
    var userTimingVariableName: String? = null
        set(value) = setProperty(value, UserTimingVariableName) { field = it }
    var userTimingTime: Int? = null
        set(value) = setProperty(value, UserTimingTime) { field = it }
    var userTimingLabel: String? = null
        set(value) = setProperty(value, UserTimingLabel) { field = it }
    var pageLoadTime: Int? = null
        set(value) = setProperty(value, PageLoadTime) { field = it }
    var dnsTime: Int? = null
        set(value) = setProperty(value, DnsTime) { field = it }
    var pageDownloadTime: Int? = null
        set(value) = setProperty(value, PageDownloadTime) { field = it }
    var redirectResponseTime: Int? = null
        set(value) = setProperty(value, RedirectResponseTime) { field = it }
    var tcpConnectTime: Int? = null
        set(value) = setProperty(value, TcpConnectTime) { field = it }
    var serverResponseTime: Int? = null
        set(value) = setProperty(value, ServerResponseTime) { field = it }
    var domInteractiveTime: Int? = null
        set(value) = setProperty(value, DomInteractiveTime) { field = it }
    var contentLoadTime: Int? = null
        set(value) = setProperty(value, ContentLoadTime) { field = it }

    // exceptions
    var exceptionDescription: String? = null
        set(value) = setProperty(value, ExceptionDescription) { field = it }
    var isExceptionFatal: Boolean? = null
        set(value) = setProperty(value, IsExceptionFatal) { field = it }

    // custom dimension/metrics
    var customDimension: Pair<Int, String>? = null
        set(value) = setCustomDimension(value, { CustomDimension(it) }) { field = it }
    var customMetrics: Pair<Int, Int>? = null
        set(value) = setCustomMetrics(value, { CustomMetrics(it) }) { field = it }

    // content experiments
    var experimentId: String? = null
        set(value) = setProperty(value, ExperimentId) { field = it }
    var experimentVariant: String? = null
        set(value) = setProperty(value, ExperimentVariant) { field = it }

    private val params: MutableMap<Parameter, String> = mutableMapOf()
    private val contentGroups: MutableMap<Int, ContentGroup> = mutableMapOf()
    private val customDimensions: MutableMap<Int, Pair<CustomDimension, String>> = mutableMapOf()
    private val customMercies: MutableMap<Int, Pair<CustomMetrics, Int>> = mutableMapOf()
    private val products: MutableMap<Int, Product> = mutableMapOf()
    private val productImpressions: MutableMap<Int, MutableList<ProductImpressions>> = mutableMapOf()
    private val promotions: MutableMap<Int, Promotion> = mutableMapOf()

    fun generate(): String =
        listOf(
            params.map { "${it.key.name}=${it.value.encodeURLParameter()}" },
            contentGroups.map { it.value.params.toList() }.flatten().map { "${it.first.name}=${it.second.encodeURLParameter()}" },
            customDimensions.map { "${it.value.first.name}=${it.value.second.encodeURLParameter()}" },
            customMercies.map { "${it.value.first.name}=${it.value.second}" },

            products.map { it.value.params.toList() }.flatten().map { "${it.first.name}=${it.second.encodeURLParameter()}" },
            products.map { it.value.customDimensions.toList() }.flatten().map { (_, cd) -> "${cd.first.name}=${cd.second.encodeURLParameter()}" },
            products.map { it.value.customMercies.toList() }.flatten().map { (_, cm) -> "${cm.first.name}=${cm.second}" },

            productImpressions.map { it.value }.flatten().map { it.params.toList() }.flatten().map { "${it.first.name}=${it.second.encodeURLParameter()}" },
            productImpressions.map { it.value }.flatten()
                .map { it.products.toList() }.flatten()
                .map { (_, prd) -> prd.params.toList() }.flatten()
                .map { "${it.first.name}=${it.second.encodeURLParameter()}" },
            productImpressions.map { it.value }.flatten()
                .map { it.products.toList() }.flatten()
                .map { (_, prd) -> prd.customDimensions.toList() }.flatten()
                .map { (_, cd) -> "${cd.first.name}=${cd.second.encodeURLParameter()}" },
            productImpressions.map { it.value }.flatten()
                .map { it.products.toList() }.flatten()
                .map { (_, prd) -> prd.customMercies.toList() }.flatten()
                .map { (_, cd) -> "${cd.first.name}=${cd.second}" },

            promotions.map { it.value.params.toList() }.flatten().map { "${it.first.name}=${it.second.encodeURLParameter()}" }

        ).flatten().joinToString("&").also {
            params.clear()
            customDimensions.clear()
            customMercies.clear()
            products.clear()
            productImpressions.clear()
            promotions.clear()
        }

    private fun setParam(parameter: Parameter, value: Any?) {
        value?.also {
            validType(parameter, it)
            (when (it) {
                is HitType -> it.type
                is Boolean -> if (it) "1" else "0"
                else -> it.toString()
            }).let { param ->
                params[parameter] = param
            }
        } ?: params.remove(parameter)
    }

    private fun setCustomDimension(
        value: Pair<Int, String>?,
        fixIndexFunc: (Int) -> CustomDimension,
        setFiledFunc: (Pair<Int, String>?) -> Unit
    ) {
        value?.first?.let {
            validType(CustomDimension(value.first), value.second)
            customDimensions.put(value.first, fixIndexFunc(it) to value.second)
        }
        setFiledFunc(value)
    }

    private fun setCustomMetrics(
        value: Pair<Int, Int>?,
        fixIndexFunc: (Int) -> CustomMetrics,
        setFiledFunc: (Pair<Int, Int>?) -> Unit
    ) {
        value?.first?.let {
            validType(CustomMetrics(value.first), value.second)
            customMercies.put(value.first, fixIndexFunc(it) to value.second)
        }
        setFiledFunc(value)
    }

    private fun <T : Any> setProperty(value: T?, parameter: Parameter, fn: (T?) -> Unit) {
        setParam(parameter, value)
        fn(value)
    }
}
