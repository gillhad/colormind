package com.gillhad.game.models

import com.gillhad.domain.models.ColorRow
import com.gillhad.shared.enums.PuzzleColors
import com.gillhad.shared.enums.ScreenStates

data class GameScreenState(
    var hasWon: Boolean = false,
    var hasLost: Boolean = false,
    var amount: Int = 0,
    var listColorRows: List<ColorRow> = mutableListOf(),
    var currentRow: ColorRow = ColorRow(mutableListOf()),
    var currentPuzzle: ColorRow = ColorRow(mutableListOf()),
    var currentColors: List<PuzzleColors> = listOf(),
    var spotSelected: Int? = null,
    var attempts: Int = 0,
    var maxAttempts: Int = 5,
    var uiState: GameScreenUiState = GameScreenUiState()
)

//Do i want to have dialogs or different screens?
//Should I manage everything from screenStates or have separate logic?
data class GameScreenUiState(
    var screenStates: ScreenStates = ScreenStates.IDLE,
    var showWinDialog: Boolean = false,
    var showLostDialog: Boolean = false
)