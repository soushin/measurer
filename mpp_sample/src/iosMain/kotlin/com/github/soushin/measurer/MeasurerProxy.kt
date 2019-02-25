package com.github.soushin.measurer

import kotlinx.coroutines.launch

fun pageTracking(tid: String) {
    NativeScope().launch {
        GoogleAnalytics().pageTracking(tid)
    }
}
