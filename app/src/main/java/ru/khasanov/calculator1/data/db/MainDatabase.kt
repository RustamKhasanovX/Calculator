package ru.khasanov.calculator1.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.khasanov.calculator1.data.db.history.HistoryItemDao
import ru.khasanov.calculator1.data.db.history.HistoryItemEntity
import ru.khasanov.calculator1.data.db.typeConverters.LocalDateTimeConverter

@Database(
    entities = [HistoryItemEntity::class],
    version = 2,
    exportSchema = true
)
@TypeConverters(LocalDateTimeConverter::class)

abstract class MainDatabase : RoomDatabase() {

    abstract val historyItemDao: HistoryItemDao

    companion object {

        fun create(context: Context): MainDatabase =
            Room.databaseBuilder(context, MainDatabase::class.java, "main_database")
                .build()
    }
}

