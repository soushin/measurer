package com.github.soushin.measurer.parameter

interface Parameter {
    val name: String
    val type: Type
    val maxLength: Int?
}

enum class Type {
    String {
        override fun <T> validType(value: T) = value is kotlin.String
    },
    Bool {
        override fun <T> validType(value: T) = value is kotlin.Boolean
    },
    Int {
        override fun <T> validType(value: T) = value is kotlin.Int
    },
    Double {
        override fun <T> validType(value: T) = value is kotlin.Double
    },
    Hit {
        override fun <T> validType(value: T) =
            value is HitType && HitType.values().contains(value)
    };

    abstract fun <T> validType(value: T): Boolean
}

enum class HitType(val type: String) {
    PageView("pageview"),
    ScreenView("screenview"),
    Event("event"),
    Transaction("transaction"),
    Item("item"),
    Social("social"),
    Exception("exception"),
    Timing("timing")
}
