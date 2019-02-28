package com.github.soushin.measurer.sample

import com.github.soushin.measurer.GoogleAnalytics
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        GoogleAnalytics().pageTracking("your tracking id") // value is like 'UA-12345678-1'
    }
}
