@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.optionals

import java.util.*

inline fun <T> T.toOptional(): Optional<T> = Optional.of(this)