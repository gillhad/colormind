package com.gillhad.shared.enums

import androidx.compose.ui.graphics.Color
import com.gillhad.designsystem.theme.spotColorBlue
import com.gillhad.designsystem.theme.spotColorClose
import com.gillhad.designsystem.theme.spotColorDefault
import com.gillhad.designsystem.theme.spotColorGreen
import com.gillhad.designsystem.theme.spotColorPurple
import com.gillhad.designsystem.theme.spotColorRed
import com.gillhad.designsystem.theme.spotColorValid
import com.gillhad.designsystem.theme.spotColorYellow

enum class PuzzleColors(val color: Color, val isPuzzleColor: Boolean) {
    DEFAULT(spotColorDefault, true),
    GREEN(spotColorGreen, true),
    RED(spotColorRed, true),
    YELLOW(spotColorYellow, true),
    PURPLE(spotColorPurple, true),
    BLUE(spotColorBlue, true),

    VALID(spotColorValid, false),
    CLOSE(spotColorClose, false);

    companion object {

        fun getPuzzleColor(): List<PuzzleColors> {
            return entries.filter { it.isPuzzleColor }
        }
    }
}

val listOfPuzzleColors = PuzzleColors.getPuzzleColor()
