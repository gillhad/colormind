package com.vueling.domain.models.mocks

import com.gillhad.shared.enums.PuzzleColors
import com.vueling.domain.models.ColorRow
import com.vueling.domain.models.SpotColor

abstract class MockColorRow {
    companion object {

        fun getBasicSpot(): SpotColor {
            return SpotColor()
        }

        fun getCustomSpotColorMock(color: PuzzleColors): SpotColor {
            return SpotColor(color)
        }

        fun getBasicColorRowMock(): ColorRow {
            return ColorRow(
                spotList = mutableListOf(getBasicSpot(), getBasicSpot(), getBasicSpot()).toList(),
            )
        }

        fun getCustomColorRowMock(color: PuzzleColors): ColorRow {
            return ColorRow(
                mutableListOf(
                    getCustomSpotColorMock(color),
                    getCustomSpotColorMock(color),
                    getCustomSpotColorMock(color),
                    getCustomSpotColorMock(color),
                    getCustomSpotColorMock(color)
                )
            )
        }

        fun getCurrentPuzzleMock(): ColorRow {
            return ColorRow(
                mutableListOf(
                    getCustomSpotColorMock(PuzzleColors.GREEN),
                    getCustomSpotColorMock(PuzzleColors.RED),
                    getCustomSpotColorMock(PuzzleColors.PURPLE),
                    getCustomSpotColorMock(PuzzleColors.YELLOW),
                    getCustomSpotColorMock(PuzzleColors.BLUE)
                )
            )
        }

        fun getColorRowValidated(): ColorRow {
            return ColorRow(
                mutableListOf(
                    getCustomSpotColorMock(PuzzleColors.GREEN),
                    getCustomSpotColorMock(PuzzleColors.RED),
                    getCustomSpotColorMock(PuzzleColors.PURPLE),
                    getCustomSpotColorMock(PuzzleColors.YELLOW),
                    getCustomSpotColorMock(PuzzleColors.BLUE)
                ),
                mutableListOf(
                    getCustomSpotColorMock(PuzzleColors.GREEN),
                    getCustomSpotColorMock(PuzzleColors.RED),
                    getCustomSpotColorMock(PuzzleColors.PURPLE),
                    getCustomSpotColorMock(PuzzleColors.YELLOW),
                    getCustomSpotColorMock(PuzzleColors.BLUE)
                )
            )
        }
    }
}