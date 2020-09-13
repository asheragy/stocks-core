package org.cerion.stocks.core.platform

@Suppress("NO_ACTUAL_FOR_EXPECT") // TODO temporary for KMP bug
expect class KMPDate(year: Int, month: Int, date: Int) : Comparable<KMPDate> {
    fun toISOString(): String
    val time: Long
    val dayOfWeek: DayOfWeek
    val year: Int
    val date: Int
    val month: Int

    fun add(days: Int): KMPDate
    fun diff(other: KMPDate): Int

    override fun equals(other: Any?): Boolean

    companion object {
        val TODAY: KMPDate
    }
}

enum class DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}