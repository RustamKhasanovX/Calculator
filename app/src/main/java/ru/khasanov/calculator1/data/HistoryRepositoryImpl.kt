package ru.khasanov.calculator1.data

import ru.khasanov.calculator1.data.db.history.HistoryItemDao
import ru.khasanov.calculator1.data.db.history.HistoryItemEntity
import ru.khasanov.calculator1.domain.HistoryRepository
import ru.khasanov.calculator1.domain.entity.HistoryItem

class HistoryRepositoryImpl(
    private val historyItemDao: HistoryItemDao,
) : HistoryRepository {

    override suspend fun add(historyItem: HistoryItem) {
        historyItemDao.insert(historyItem.toHistoryItemEntity())
    }

    override suspend fun getAll(): List<HistoryItem> =
        historyItemDao.getAll().map { it.toHistoryItem() }

    private fun HistoryItem.toHistoryItemEntity() = HistoryItemEntity(
        id = 0,
        expression = expression,
        result = result
    )

    private fun HistoryItemEntity.toHistoryItem() = HistoryItem(
        expression = expression,
        result = result
    )

}