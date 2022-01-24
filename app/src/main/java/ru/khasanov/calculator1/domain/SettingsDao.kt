package ru.khasanov.calculator1.domain

import ru.khasanov.calculator1.domain.entity.ResultPanelType

interface SettingsDao {

    suspend fun getResultPanelType(): ResultPanelType
    suspend fun setResultPanelType(resultPanelType: ResultPanelType)

    suspend fun getPrecision(): Int
    suspend fun setPrecision(precision: Int)

    suspend fun getVibration(): Int
    suspend fun setVibration(vibration: Int)

}

