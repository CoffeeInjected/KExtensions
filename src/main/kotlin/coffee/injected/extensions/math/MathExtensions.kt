@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.math

import kotlin.math.*

inline val Long.isEven: Boolean get() = this % 2L == 0L
inline val Number.isEven: Boolean get() = toLong().isEven

inline val Long.isOdd: Boolean get() = !isEven
inline val Number.isOdd: Boolean get() = toLong().isOdd

inline val Int.isPositive: Boolean get() = this > 0
inline val Int.isNegative: Boolean get() = this < 0

inline fun Number.floor(): Double = floor(toDouble())
inline fun Number.ceil(): Double = ceil(toDouble())
inline fun Number.abs(): Int = abs(toInt())
inline fun Number.round(): Double = round(toDouble())
inline fun Number.sqrt(): Double = sqrt(toDouble())
inline fun Number.cbrt(): Double = Math.cbrt(toDouble())

inline infix fun Int.plusMinus(range: Int): IntRange = IntRange(this - range, this + range)

inline infix fun Number.fdiv(y: Number): Float = toFloat() / y.toFloat()
inline infix fun Number.ddiv(y: Number): Double = toDouble() / y.toDouble()

inline infix fun Number.roundDiv(y: Number): Long = ddiv(y).roundToLong()

inline fun Double.sin(): Double = sin(this)
inline fun Float.sin(): Float = toDouble().sin().toFloat()

inline fun Double.cos(): Double = cos(this)
inline fun Float.cos(): Float = toDouble().cos().toFloat()

inline fun Double.tan(): Double = tan(this)
inline fun Float.tan(): Float = toDouble().tan().toFloat()

inline fun Double.asin(): Double = asin(this)
inline fun Float.asin(): Float = toDouble().asin().toFloat()

inline fun Double.acos(): Double = acos(this)
inline fun Float.acos(): Float = toDouble().acos().toFloat()

inline fun Double.atan(): Double = atan(this)
inline fun Float.atan(): Float = toDouble().atan().toFloat()

inline fun Double.toRadians(): Double = Math.toRadians(this)
inline fun Float.toRadians(): Float = toDouble().toRadians().toFloat()

inline fun Double.toDegrees(): Double = Math.toDegrees(this)
inline fun Float.toDegrees(): Float = toDouble().toDegrees().toFloat()

inline fun Double.exp(): Double = exp(this)
inline fun Float.exp(): Float = toDouble().exp().toFloat()

inline fun Double.log(): Double = ln(this)
inline fun Float.log(): Float = toDouble().log().toFloat()
inline fun Double.ln(): Double = log()
inline fun Float.ln(): Float = log()
inline fun Number.log(): Double = toDouble().log()
inline fun Number.ln(): Double = toDouble().log()

inline fun Double.log10(): Double = log10(this)
inline fun Float.log10(): Float = toDouble().log10().toFloat()
inline fun Number.log10(): Double = toDouble().log10()

inline fun Double.cbrt(): Double = Math.cbrt(this)
inline fun Float.cbrt(): Float = toDouble().cbrt().toFloat()

inline infix fun Double.IEEEremainder(divisor: Double): Double = IEEErem(divisor)
inline infix fun Float.IEEEremainder(divisor: Double): Float = toDouble().IEEEremainder(divisor).toFloat()

inline fun Double.rint(): Double = round(this)
inline fun Float.rint(): Float = toDouble().rint().toFloat()

inline fun Double.atan2(x: Double): Double = atan2(this, x)
inline fun Float.atan2(x: Float): Float = toDouble().atan2(x.toDouble()).toFloat()

inline fun Double.ulp(): Double = Math.ulp(this)
inline fun Float.ulp(): Float = Math.ulp(toDouble()).toFloat()

inline fun Double.sign(): Double = sign(this)
inline fun Float.sign(): Float = sign(toDouble()).toFloat()

inline fun Double.sinh(): Double = sinh(this)
inline fun Float.sinh(): Float = sinh(toDouble()).toFloat()

inline fun Double.cosh(): Double = cosh(this)
inline fun Float.cosh(): Float = cosh(toDouble()).toFloat()

inline fun Double.tanh(): Double = tanh(this)
inline fun Float.tanh(): Float = tanh(toDouble()).toFloat()

inline fun Double.expm1(): Double = expm1(this)
inline fun Float.expm1(): Float = expm1(toDouble()).toFloat()

inline fun Double.log1p(): Double = ln1p(this)
inline fun Float.log1p(): Float = ln1p(toDouble()).toFloat()

inline fun Double.exponent(): Int = Math.getExponent(this)
inline fun Float.exponent(): Int = Math.getExponent(this)

inline fun Double.next(direction: Double = Double.POSITIVE_INFINITY): Double = this.nextTowards(direction)
inline fun Float.next(direction: Double = Double.POSITIVE_INFINITY): Float = this.nextTowards(direction.toFloat())

inline infix fun Double.scalb(scaleFactor: Int): Double = Math.scalb(this, scaleFactor)
inline infix fun Float.scalb(scaleFactor: Int): Float = Math.scalb(this, scaleFactor)

inline fun Int.setBit(i: Int, v: Int): Int =  if (v == 1) this or (1 shl i) else ((this or (1 shl i)) xor (1 shl i))
inline fun Long.setBit(i: Int, v: Int): Long = if (v == 1) this or (1L shl i) else ((this or (1L shl i)) xor (1L shl i))

inline fun Int.getBit(i: Int): Int  = (this shr i) and 1
inline fun Long.getBit(i: Int): Int = ((this shr i) and 1L).toInt()

inline fun Float.toPercents() : Int = (this * 100).toInt()
inline fun Double.toPercents() : Int = (this * 100).toInt()

inline fun Int.fromPercents() : Float = this.toFloat() / 100
inline fun Int.fromPercentsD() : Double = this.toDouble() / 100