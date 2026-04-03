package com.gillhad.domain.models

import com.gillhad.shared.enums.PuzzleColors

data class SpotColor(
    var selectedColor: PuzzleColors = PuzzleColors.DEFAULT
)