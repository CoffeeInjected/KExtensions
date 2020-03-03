@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.collections

import coffee.injected.extensions.tuples.joinToString

inline fun <K, V> Map<K, V>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "{ ",
    postfix: CharSequence = " }",
    limit: Int = -1,
    truncated: CharSequence = "...",
    noinline transform: (Pair<K, V>) -> CharSequence = { entry ->
        entry.joinToString(
            ": ",
            secondTransform = { it.toString() })
    }
) = toList().joinToString(separator, prefix, postfix, limit, truncated, transform)