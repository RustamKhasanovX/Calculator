package ru.khasanov.calculator1.domain.entity

data class SettingsBody(
    val resultPanelType: ResultPanelType,
    val vibrationIntensity: Int,
    val precision: Int,
)