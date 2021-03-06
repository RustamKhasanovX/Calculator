package ru.khasanov.calculator1.data.db.typeConverters

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class LocalDateTimeConverter {

    @TypeConverter
    fun toString(localDateTime: LocalDateTime): String =
        localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)


    @TypeConverter
    fun toLocalDateTime(value: String?): LocalDateTime =
        LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

}

fun history(localDateTime: LocalDateTime): String {
    return localDateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss dd MMMM yyyy года",
        Locale("ru")))
}