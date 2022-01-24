package ru.khasanov.calculator1.di

import android.content.Context
import ru.khasanov.calculator1.data.db.MainDatabase

object DatabaseProvider {

    private var db: MainDatabase? = null

    fun get(context: Context): MainDatabase {
        return db ?: MainDatabase.create(context).also { db = it }
    }
}

