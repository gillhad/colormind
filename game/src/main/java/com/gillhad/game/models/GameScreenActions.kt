package com.gillhad.game.models

import com.gillhad.shared.enums.PuzzleColors

data class GameScreenActions(
    val onValidateRow: () -> Unit,
    val onSpotSelected: (Int) -> Unit,
    val onColorSelected: (PuzzleColors) -> Unit
)