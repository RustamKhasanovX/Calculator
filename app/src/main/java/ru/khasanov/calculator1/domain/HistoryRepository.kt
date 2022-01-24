package ru.khasanov.calculator1.domain

import ru.khasanov.calculator1.domain.entity.HistoryItem

interface HistoryRepository {

    suspend fun add(historyItem: HistoryItem)

    suspend fun getAll(): List<HistoryItem>
}