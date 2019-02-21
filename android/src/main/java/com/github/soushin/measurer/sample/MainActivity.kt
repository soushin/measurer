package com.github.soushin.measurer.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.soushin.measurer.GoogleAnalytics
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    companion object {
        private val TRACKING_ID = "your tracking id" // value is like 'UA-12345678-1'
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            GoogleAnalytics.pageTracking(TRACKING_ID)
            GoogleAnalytics.eventTracking(TRACKING_ID)
        }
    }
}
