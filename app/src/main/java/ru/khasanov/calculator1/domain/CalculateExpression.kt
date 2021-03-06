package ru.khasanov.calculator1.domain

import com.fathzer.soft.javaluator.DoubleEvaluator
import kotlin.math.floor

/**
 *  Calculate [expression]
 */

fun calculateExpression(expression: String, precisionResult: Int): String {

    if (expression.isBlank()) return ""

    var formattedExpression = expression
    while (formattedExpression.isNotBlank() && !formattedExpression.last().isDigit() &&
        formattedExpression.last() != ')'
    ) {
        formattedExpression = formattedExpression.dropLast(1)
    }

    while (formattedExpression.isNotBlank() && !formattedExpression.first().isDigit() &&
        formattedExpression.first() != ')' && formattedExpression.first() != '-'
    ) {
        formattedExpression = formattedExpression.drop(1)
    }

    if (formattedExpression.isBlank()) return ""

    val result = try {
        DoubleEvaluator().evaluate(formattedExpression)
    } catch (e: IllegalArgumentException) {
        null
    }

    return when (result) {
        null -> {
            "Wrong"
        }
        floor(result) -> {
            result.toLong().toString()
        }
        else -> {
            "%.${precisionResult}f".format(result)
        }
    }
}