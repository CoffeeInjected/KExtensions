@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.booleans

inline fun Boolean.toByte(): Byte = if (this) 1.toByte() else 0.toByte()
inline fun Boolean.toShort(): Short = if (this) 1 else 0
inline fun Boolean.toInt(): Int = if (this) 1 else 0
inline fun Boolean.toLong(): Long = if (this) 1 else 0
inline fun Boolean.toFloat(): Float = if (this) 1f else 0f
inline fun Boolean.toDouble(): Double = if (this) 1.0 else 0.0

inline fun Byte.toBoolean(): Boolean = this == 1.toByte()
inline fun Short.toBoolean(): Boolean = this == 1.toShort()
inline fun Int.toBoolean(): Boolean = this == 1
inline fun Long.toBoolean(): Boolean = this == 1L
inline fun Float.toBoolean(): Boolean = this == 1f
inline fun Double.toBoolean(): Boolean = this == 1.0