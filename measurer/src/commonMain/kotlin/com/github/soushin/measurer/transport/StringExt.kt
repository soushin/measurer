package com.github.soushin.measurer.transport

import kotlinx.io.charsets.Charsets
import kotlinx.io.charsets.encode
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.takeWhile

private val URL_ALPHABET = (('a'..'z') + ('A'..'Z') + ('0'..'9')).map { it.toByte() }
private val OAUTH_SYMBOLS = listOf('-', '.', '_', '~').map { it.toByte() }

fun String.encodeURLParameter(
    spaceToPlus: Boolean = false
): String = buildString {
    val content = Charsets.UTF_8.newEncoder().encode(this@encodeURLParameter)
    content.forEach {
        when {
            it in URL_ALPHABET || it in OAUTH_SYMBOLS -> append(it.toChar())
            spaceToPlus && it == ' '.toByte() -> append('+')
            else -> append(it.percentEncode())
        }
    }
}

private fun Byte.percentEncode(): String {
    val code = (toInt() and 0xff).toString(radix = 16).toUpperCase()
    return "%${code.padStart(length = 2, padChar = '0')}"
}

private fun ByteReadPacket.forEach(block: (Byte) -> Unit) {
    takeWhile { buffer ->
        while (buffer.canRead()) {
            block(buffer.readByte())
        }
        true
    }
}
