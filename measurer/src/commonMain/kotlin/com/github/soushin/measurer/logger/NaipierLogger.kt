package com.github.soushin.measurer.logger

import com.github.aakira.napier.Napier
import com.github.soushin.measurer.Logger

class NapierLogger : Logger {

    override fun v(message: String, throwable: Throwable?, tag: String?) {
        Napier.v(message, throwable, tag)
    }

    override fun i(message: String, throwable: Throwable?, tag: String?) {
        Napier.i(message, throwable, tag)
    }

    override fun d(message: String, throwable: Throwable?, tag: String?) {
        Napier.d(message, throwable, tag)
    }

    override fun w(message: String, throwable: Throwable?, tag: String?) {
        Napier.w(message, throwable, tag)
    }

    override fun e(message: String, throwable: Throwable?, tag: String?) {
        Napier.e(message, throwable, tag)
    }

    override fun wtf(message: String, throwable: Throwable?, tag: String?) {
        Napier.wtf(message, throwable, tag)
    }
}
