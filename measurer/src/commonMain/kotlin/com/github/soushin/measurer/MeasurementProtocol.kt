package com.github.soushin.measurer

import com.github.soushin.measurer.httpclient.HttpClient
import com.github.soushin.measurer.logger.NapierLogger
import com.github.soushin.measurer.transport.EventPayload
import com.github.soushin.measurer.transport.ExceptionPayload
import com.github.soushin.measurer.transport.ItemPayload
import com.github.soushin.measurer.transport.PageViewPayload
import com.github.soushin.measurer.transport.Payload
import com.github.soushin.measurer.transport.PostBatch
import com.github.soushin.measurer.transport.PostCollect
import com.github.soushin.measurer.transport.ScreenViewPayload
import com.github.soushin.measurer.transport.SocialPayload
import com.github.soushin.measurer.transport.TimingPayload
import com.github.soushin.measurer.transport.TransactionPayload
import com.github.soushin.measurer.transport.TransportConfig

class MeasurementProtocol {

    companion object {
        private val BATCH_LIMIT_SIZE = 20
    }

    lateinit var tId: String
    lateinit var log: Logger

    lateinit var httpCli: HttpClient
    var ua: String = TransportConfig.MEASURER_USER_AGENT

    private
    val payloads: MutableList<Payload> = mutableListOf()

    class Builder(
        val trackingId: String,
        private val logger: Logger = NapierLogger(),
        private val httpClient: HttpClient? = null,
        private val userAgent: String? = null
    ) {
        fun build(): MeasurementProtocol {
            return MeasurementProtocol().apply {
                this.tId = trackingId
                httpClient?.let {
                    this.httpCli = it
                }
                userAgent?.let {
                    this.ua = it
                }
                this.log = logger
            }
        }
    }

    suspend fun send() {
        (if (payloads.size > 1) {
            (payloads.size <= BATCH_LIMIT_SIZE).takeIf { it }?.run {
                PostBatch(ua, payloads.joinToString("\n") { it.generate() })
            } ?: log.e("Google Analytics batch size error: payload size=${payloads.size}").run { null }
        } else {
            PostCollect(ua, payloads[0].generate())
        })?.let {
            httpCli.request(it)
        }
    }

    fun pageView(documentHostName: String, documentPath: String): Payload =
        PageViewPayload(documentHostName = documentHostName, documentPath = documentPath, trackingId = tId).also {
            payloads.add(it)
        }

    fun screenView(screenName: String): Payload =
        ScreenViewPayload(screenName = screenName, trackingId = tId).also {
            payloads.add(it)
        }

    fun event(eventCategory: String, eventAction: String): Payload =
        EventPayload(eventCategory = eventCategory, eventAction = eventAction, trackingId = tId).also {
            payloads.add(it)
        }

    fun transaction(transactionId: String): Payload =
        TransactionPayload(transactionId = transactionId, trackingId = tId).also {
            payloads.add(it)
        }

    fun item(transactionId: String, itemName: String): Payload =
        ItemPayload(transactionId = transactionId, itemName = itemName, trackingId = tId).also {
            payloads.add(it)
        }

    fun social(socialNetwork: String, socialAction: String, socialActionTarget: String): Payload =
        SocialPayload(
            socialNetwork = socialNetwork,
            socialAction = socialAction,
            socialActionTarget = socialActionTarget,
            trackingId = tId
        ).also {
            payloads.add(it)
        }

    fun exception(): Payload =
        ExceptionPayload(trackingId = tId).also {
            payloads.add(it)
        }

    fun timing(userTimingCategory: String, userTimingVariableName: String, userTimingTime: Int): Payload =
        TimingPayload(
            userTimingCategory = userTimingCategory,
            userTimingVariableName = userTimingVariableName,
            userTimingTime = userTimingTime,
            trackingId = tId
        ).also {
            payloads.add(it)
        }
}
