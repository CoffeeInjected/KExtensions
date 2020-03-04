@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.throwable

import java.io.PrintWriter
import java.io.StringWriter

inline fun Throwable.printStackTraceToString(): String {
    val writer = StringWriter()
    printStackTrace(PrintWriter(writer))
    return writer.toString()
}
