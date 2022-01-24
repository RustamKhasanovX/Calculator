package ru.khasanov.calculator1.di

import android.content.Context
import ru.khasanov.calculator1.data.SettingsDaoImpl
import ru.khasanov.calculator1.domain.SettingsDao

object SettingsDaoProvider {

    private var dao: SettingsDao? = null

    fun getDao(context: Context): SettingsDao {
        return dao ?: run {
            val dao = SettingsDaoImpl(
                context.getSharedPreferences(
                    "settings",
                    Context.MODE_PRIVATE
                )
            )
            this.dao = dao
            dao
        }
    }
}

