package com.vueling.domain.models

import com.gillhad.shared.enums.PuzzleColors

data class SpotColor(
    var selectedColor: PuzzleColors = PuzzleColors.DEFAULT
)