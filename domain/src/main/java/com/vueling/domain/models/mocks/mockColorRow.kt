package com.vueling.domain.models.mocks

import androidx.compose.ui.graphics.Color
import com.gillhad.designsystem.theme.spotColorClose
import com.gillhad.designsystem.theme.spotColorDefault
import com.gillhad.designsystem.theme.spotColorGreen
import com.gillhad.designsystem.theme.spotColorPurple
import com.gillhad.designsystem.theme.spotColorRed
import com.gillhad.designsystem.theme.spotColorValid
import com.gillhad.designsystem.theme.spotColorYellow
import com.vueling.domain.models.ColorRow
import com.vueling.domain.models.SpotColor

abstract class MockColorRow {
    companion object {

        fun getBasicSpot(): SpotColor {
            return SpotColor(spotColorDefault, spotColorDefault)
        }

        fun getCustomSpotColorMock(color: Color): SpotColor {
            return SpotColor(spotColorDefault, color)
        }

        fun getBasicColorRowMock(): ColorRow {
            return ColorRow(
                spotList = mutableListOf(getBasicSpot(), getBasicSpot(), getBasicSpot()).toList(),
                validationList = null
            )
        }

        fun getCustomColorRowMock(color: Color): ColorRow {
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
                    getCustomSpotColorMock(spotColorGreen),
                    getCustomSpotColorMock(spotColorRed),
                    getCustomSpotColorMock(spotColorPurple),
                    getCustomSpotColorMock(spotColorYellow),
                    getCustomSpotColorMock(spotColorRed)
                )
            )
        }

        fun getColorRowValidated(): ColorRow {
            return ColorRow(
                mutableListOf(
                    getCustomSpotColorMock(spotColorGreen),
                    getCustomSpotColorMock(spotColorRed),
                    getCustomSpotColorMock(spotColorPurple),
                    getCustomSpotColorMock(spotColorYellow),
                    getCustomSpotColorMock(spotColorRed)
                ),
                mutableListOf(
                    getCustomSpotColorMock(spotColorClose),
                    getCustomSpotColorMock(spotColorDefault),
                    getCustomSpotColorMock(spotColorValid),
                    getCustomSpotColorMock(spotColorClose),
                    getCustomSpotColorMock(spotColorDefault)
                )
            )
        }
    }
}