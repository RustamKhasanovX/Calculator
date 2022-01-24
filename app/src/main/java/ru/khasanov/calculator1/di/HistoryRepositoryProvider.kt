package ru.khasanov.calculator1.di

import android.content.Context
import ru.khasanov.calculator1.data.HistoryRepositoryImpl
import ru.khasanov.calculator1.domain.HistoryRepository

object HistoryRepositoryProvider {

    private var repository: HistoryRepository? = null

    fun get(context: Context): HistoryRepository =
        repository ?: HistoryRepositoryImpl(DatabaseProvider.get(context).historyItemDao)
            .also { repository = it }
}