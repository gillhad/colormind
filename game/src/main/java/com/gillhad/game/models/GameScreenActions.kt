package com.gillhad.game.models

import com.vueling.domain.models.ColorRow

data class GameScreenActions(
    val onValidateRow: (ColorRow) -> Unit,
    val onSpotSelected: (Int) -> Unit
)