@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.strings

import java.net.URI
import java.net.URL
import java.util.*

inline infix operator fun String.times(n: Int): String = repeat(n)
inline infix operator fun Int.times(s: String): String = s.repeat(this)

inline fun Double.toFixed(digits: Int): String = java.lang.String.format("%.${digits}f", this)
inline fun Float.toFixed(digits: Int): String = toDouble().toFixed(digits)

inline fun String?.isNotNullOrBlank(): Boolean = !isNullOrBlank()

inline fun concat(vararg params: Any?): String = params.joinToString("")

inline fun join(vararg params: Any?): String = params.joinToString(" ")

inline fun joinWith(separator: String = " ", vararg params: Any?) = params.joinToString(separator)

inline fun String.replace(ignoreCase: Boolean = false, vararg vars: Pair<String, String>): String {
    var copy = this
    vars.forEach { copy = copy.replace(it.first, it.second, ignoreCase) }
    return copy
}

inline fun String.remove(substring: String): String = replace(substring, "")

inline fun String.toURI(): URI = URI.create(this)

inline fun String.toURL(): URL = URL(this)

inline val String.base64Decoded: String get() = String(Base64.getDecoder().decode(toByteArray()))

inline val String.base64Encoded: String get() = Base64.getEncoder().encodeToString(toByteArray())