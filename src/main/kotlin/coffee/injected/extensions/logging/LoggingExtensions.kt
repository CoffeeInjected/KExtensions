@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.logging

import java.util.logging.Logger

inline val Any.logger: Logger
    get() = Logger.getLogger(this::class.java.simpleName)

inline fun Logger.severe(any: Any?) = severe(any.toString())
inline fun Logger.warning(any: Any?) = warning(any.toString())
inline fun Logger.info(any: Any?) = info(any.toString())
inline fun Logger.config(any: Any?) = config(any.toString())
inline fun Logger.fine(any: Any?) = fine(any.toString())
inline fun Logger.finer(any: Any?) = finer(any.toString())
inline fun Logger.finest(any: Any?) = finest(any.toString())