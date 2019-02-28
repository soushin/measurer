package com.github.soushin.measurer

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.coroutines.EmptyCoroutineContext

actual fun <T> runTest(block: suspend () -> T) {
    GlobalScope.promise(EmptyCoroutineContext) { block() }
}
