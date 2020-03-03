@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.common

import java.io.PrintStream

inline fun loop(block: () -> Unit) = run { while (true) block() }

inline infix fun <T> T.with(noinline block: (T.() -> T)?): T = block?.invoke(this) ?: this

inline fun <T> T.asNullable(): T? = this

inline fun <T> T?.isNull(): Boolean = this == null
inline fun <T> T?.isNotNull(): Boolean = this != null

inline fun <T> T?.print(
    outStream: PrintStream = System.out,
    noinline transform: (String) -> String = { "$it = " }
): T? =
    also { outStream.print(toString().with(transform)) }

inline fun <T, R> T?.println(outStream: PrintStream = System.out, what: (T?) -> R): R =
    what(this).apply { outStream.println(this) }

inline fun <T> T?.println(tag: String = "", separator: String = " = ", outStream: PrintStream = System.out): T? =
    also { outStream.println(if (tag.isBlank()) it else "$tag$separator$it") }

