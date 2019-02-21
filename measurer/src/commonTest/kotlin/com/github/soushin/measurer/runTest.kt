package com.github.soushin.measurer

expect fun <T> runTest(block: suspend () -> T)
