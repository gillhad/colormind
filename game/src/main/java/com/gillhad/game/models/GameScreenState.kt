package com.gillhad.game.models

import com.gillhad.shared.enums.PuzzleColors
import com.vueling.domain.models.ColorRow

data class GameScreenState(
    val isLoading: Boolean = false,
    var amount: Int = 0,
    var listColorRows: List<ColorRow> = mutableListOf(),
    var currentRow: ColorRow = ColorRow(mutableListOf()),
    var currentPuzzle: ColorRow = ColorRow(mutableListOf()),
    var currentColors: List<PuzzleColors> = listOf(),
    var spotSelected: Int? = null
)