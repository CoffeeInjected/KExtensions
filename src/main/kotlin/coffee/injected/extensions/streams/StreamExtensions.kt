@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.streams

import java.util.stream.Stream

inline fun <T> Array<T>.stream(): Stream<T> = Stream.of(*this)