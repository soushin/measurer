package com.github.soushin.measurer.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.soushin.measurer.MeasurementProtocol
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    companion object {
        private val TRACKING_ID = "your tracking id" // value is like 'UA-12345678-1'
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            send()
        }
    }

    suspend fun send() {
        val mp = MeasurementProtocol
            .Builder(trackingId = TRACKING_ID)
            .build()

        mp.also { ga ->
            ga.pageView(documentHostName = "hostname", documentPath = "/foo/bar").apply {
                userAgentOverride = UserAgent.get()
                clientId = ('A'..'z').map { it }.shuffled().subList(0, 10).joinToString("")
                applicationName = "Measurer SampleApp"
            }
        }.send()
    }
}
