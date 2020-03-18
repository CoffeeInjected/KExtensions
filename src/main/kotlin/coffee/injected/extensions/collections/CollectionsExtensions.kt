@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.collections

import java.util.*

inline fun <T> Collection<T>?.isBlank(): Boolean = this == null || isEmpty()

inline fun <T> Collection<T?>.anyNull(): Boolean = any { it == null }

inline fun <T> Collection<T?>.allNull(): Boolean = all { it == null }

inline fun <T> Collection<T?>.countNulls(): Int = count { it == null }
inline fun <T> Collection<T?>.countNonNulls(): Int = size - countNulls()

inline fun <T : Any> Iterable<T?>.trimNulls(): List<T> = filterNotNull()
inline fun <T : Any> Iterable<T?>.trimNullsToMutableList(): MutableList<T> = filterNotNullTo(mutableListOf())

inline fun <T1, T2> Iterable<T1>.combine(other: Iterable<T2>): List<Pair<T1, T2>> =
        combine(other) { thisItem: T1, otherItem: T2 -> Pair(thisItem, otherItem) }

inline fun <T1, T2> Iterable<T1>.combineToMutableList(other: Iterable<T2>): MutableList<Pair<T1, T2>> =
        combineToMutableList(other) { thisItem: T1, otherItem: T2 -> Pair(thisItem, otherItem) }

inline fun <T1, T2, R> Iterable<T1>.combine(
        other: Iterable<T2>,
        transform: (thisItem: T1, otherItem: T2) -> R
): List<R> = flatMap { thisItem -> other.map { otherItem -> transform(thisItem, otherItem) } }

inline fun <T1, T2, R> Iterable<T1>.combineToMutableList(
        other: Iterable<T2>,
        transform: (thisItem: T1, otherItem: T2) -> R
): MutableList<R> = flatMapTo(mutableListOf()) { thisItem -> other.map { otherItem -> transform(thisItem, otherItem) } }

inline fun <T, R> Iterable<T>.mapToMutableList(transform: (T) -> R): MutableList<R> = mapTo(mutableListOf(), transform)
inline fun <T, R> Iterable<T>.flatMapToMutableList(transform: (T) -> Iterable<R>): MutableList<R> =
        flatMapTo(mutableListOf(), transform)

inline fun <T> Int.timesToListOf(predicate: (Int) -> T): List<T> = (0 until this).map { predicate(it) }
inline fun <T> Int.timesToMutableListOf(predicate: (Int) -> T): MutableList<T> =
        (0 until this).mapToMutableList { predicate(it) }

fun <T> MutableList<T>.swap(i: Int, j: Int): MutableList<T> = apply {
    val aux = this[i]
    this[i] = this[j]
    this[j] = aux
}

fun <T> List<T>.swapped(i: Int, j: Int): List<T> = toMutableList().swap(i, j)

inline fun randomIntList(size: Int, generator: Random = Random()): List<Int> =
        size.timesToListOf { generator.nextInt() }

inline fun randomIntList(size: Int, bound: Int, generator: Random = Random()): List<Int> =
        size.timesToListOf { generator.nextInt(bound) }

inline fun randomFloatList(size: Int, generator: Random = Random()): List<Float> =
        size.timesToListOf { generator.nextFloat() }

inline fun randomDoubleList(size: Int, generator: Random = Random()): List<Double> =
        size.timesToListOf { generator.nextDouble() }

inline fun randomBooleanList(size: Int, generator: Random = Random()): List<Boolean> =
        size.timesToListOf { generator.nextBoolean() }

inline fun <E : Enum<E>> enumSetOf(type: Class<E>, vararg constants: E): EnumSet<E> {
    val set = EnumSet.noneOf(type)
    set.addAll(constants)
    return set
}

inline fun <reified E : Enum<E>> enumSetOf(vararg constants: E = enumValues()) = enumSetOf(E::class.java, *constants)