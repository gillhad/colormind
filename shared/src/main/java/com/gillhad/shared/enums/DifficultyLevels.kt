package com.gillhad.shared.enums

enum class DifficultyLevels(val colorAmount: Int) {
    EASY(3),
    MEDIUM(4),
    HARD(5),
    EXTREME(PuzzleColors.getPuzzleColor().size)
}