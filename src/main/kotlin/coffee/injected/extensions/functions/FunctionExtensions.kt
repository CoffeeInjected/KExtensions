@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.functions

import java.util.concurrent.Callable
import java.util.function.*

inline fun <R> (() -> R).run(): R = invoke()

inline fun <T> Runnable.toConsumer(): Consumer<T> = Consumer { run() }
inline fun <T> Runnable.toCallable(): Callable<T?> = Callable { run(); null }
inline fun <T, R> Runnable.toFunction(): java.util.function.Function<T, R> = Function { run(); null!! }
inline fun Runnable.toFunction(): () -> Unit = { run() }
inline fun <P1> Runnable.toFunction1(): (P1) -> Unit = { run() }
inline fun <P1, P2> Runnable.toFunction2(): (P1, P2) -> Unit = { _, _ -> run() }
inline fun <P1, P2, P3> Runnable.toFunction3(): (P1, P2, P3) -> Unit = { _, _, _ -> run() }

inline fun <T> Callable<T>.toRunnable(): Runnable = Runnable { call() }
inline fun <T> Callable<T>.toSupplier(): Supplier<T?> = Supplier { call(); null }
inline fun <T> Callable<T>.toConsumer(): Consumer<T> = Consumer { call() }
inline fun <T> Callable<T>.toFunction(): () -> T = { call() }
inline fun <P1, T> Callable<T>.toFunction1(): (P1) -> T = { call() }
inline fun <P1, P2, T> Callable<T>.toFunction2(): (P1, P2) -> T = { _, _ -> call() }
inline fun <P1, P2, P3, T> Callable<T>.toFunction3(): (P1, P2, P3) -> T = { _, _, _ -> call() }

inline fun <T> Supplier<T>.toConsumer(): Consumer<T> = Consumer { get() }
inline fun <T> Supplier<T>.toRunnable(): Runnable = Runnable { get() }
inline fun <T> Supplier<T>.toCallable(): Callable<T> = Callable { get() }
inline fun <T> Supplier<T>.toFunction(): () -> T = { get() }
inline fun <P1, T> Supplier<T>.toFunction1(): (P1) -> T = { get() }
inline fun <P1, P2, T> Supplier<T>.toFunction2(): (P1, P2) -> T = { _, _ -> get() }
inline fun <P1, P2, P3, T> Supplier<T>.toFunction3(): (P1, P2, P3) -> T = { _, _, _ -> get() }

inline fun <R> Function0<R>.toRunnable(): Runnable = Runnable { invoke() }
inline fun <R> Function0<R>.toSupplier(): Supplier<R> = Supplier { invoke() }
inline fun <R> Function0<R>.toCallable(): Callable<R> = Callable { invoke() }
inline fun <R> Function0<R>.toConsumer(): Consumer<R> = Consumer { invoke() }
inline fun <P1, R> Function0<R>.toJavaFunction(): java.util.function.Function<P1, R> = Function { invoke() }
inline fun <P1, R> Function1<P1, R>.toConsumer(): Consumer<P1> = Consumer { invoke(it) }
inline fun <P1, R> Function1<P1, R>.toJavaFunction(): java.util.function.Function<P1, R> = Function { invoke(it) }

inline fun <T, U> Consumer<T>.toBiConsumerFirst(): BiConsumer<T, U> = BiConsumer { t, _ -> accept(t) }
inline fun <T, U> Consumer<U>.toBiConsumerSecond(): BiConsumer<T, U> = BiConsumer { _, u -> accept(u) }
inline fun <T, R> Consumer<T>.toJavaFunction(): java.util.function.Function<T, R> = Function { accept(it); null!! }
inline fun <T> Consumer<T>.toFunction(): (T) -> Unit = { accept(it) }

inline fun <T, U> Predicate<T>.toBiPredicateFirst(): BiPredicate<T, U> = BiPredicate { t, _ -> test(t) }
inline fun <T, U> Predicate<U>.toBiPredicateSecond(): BiPredicate<T, U> = BiPredicate { _, u -> test(u) }

