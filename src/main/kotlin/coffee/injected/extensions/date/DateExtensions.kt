@file:Suppress("NOTHING_TO_INLINE")

package coffee.injected.extensions.date

import java.text.SimpleDateFormat
import java.util.*

inline var Date.calendar: Calendar
    get() = Calendar.getInstance().apply { time = this@calendar }
    set(value) {
        time = value.timeInMillis
    }

inline val Date.isInFuture: Boolean get() = this > Date()

inline val Date.isInPast: Boolean get() = this < Date()

inline val Date.iso8601: String
    get() = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(TimeZone.getTimeZone("UTC"))

inline fun Date.millisecondsSince(date: Date) = (time - date.time)
inline fun Date.secondsSince(date: Date): Double = millisecondsSince(date) / 1000.0
inline fun Date.minutesSince(date: Date): Double = secondsSince(date) / 60
inline fun Date.hoursSince(date: Date): Double = minutesSince(date) / 60
inline fun Date.daysSince(date: Date): Double = hoursSince(date) / 24
inline fun Date.weeksSince(date: Date): Double = daysSince(date) / 7
inline fun Date.monthsSince(date: Date): Double = weeksSince(date) / 4
inline fun Date.yearsSince(date: Date): Double = monthsSince(date) / 12
