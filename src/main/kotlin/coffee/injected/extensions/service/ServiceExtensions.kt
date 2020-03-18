@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.service

import java.util.*

inline fun <T> service(clazz: Class<T>, classLoader: ClassLoader = clazz.classLoader) = ServiceLoader.load(clazz, classLoader).first()

inline fun <reified T> service() = service(T::class.java)