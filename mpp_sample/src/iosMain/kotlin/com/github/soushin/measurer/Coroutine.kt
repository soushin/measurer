package com.github.soushin.measurer

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext

internal class NativeScope : CoroutineScope {
    private val context = MainDispatcher()
    private val job = Job()
    private val exceptionHandler = CoroutineExceptionHandler { _, _ -> }

    override val coroutineContext: CoroutineContext
        get() = context + job + exceptionHandler
}

private class MainDispatcher : CoroutineDispatcher() {

    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) { block.run() }
    }
}
