package modelsMocks

import androidx.compose.ui.graphics.Color
import com.gillhad.designsystem.theme.spotColorClose
import com.gillhad.designsystem.theme.spotColorDefault
import com.gillhad.designsystem.theme.spotColorGreen
import com.gillhad.designsystem.theme.spotColorPurple
import com.gillhad.designsystem.theme.spotColorRed
import com.gillhad.designsystem.theme.spotColorValid
import com.gillhad.designsystem.theme.spotColorYellow
import com.gillhad.shared.models.ColorRow
import com.gillhad.shared.models.SpotColor

abstract class MockColorRow {
    companion object {

        fun getBasicSpot(): SpotColor {
            return SpotColor(spotColorDefault, spotColorDefault)
        }

        fun getCustomSpotColor(color: Color): SpotColor {
            return SpotColor(spotColorDefault, color)
        }

        fun getBasicColorRow(): ColorRow {
            return ColorRow(spotAmount = 5, diffLevel = "")
        }

        fun getCustomColorRow(color: Color): ColorRow {
            return ColorRow(
                mutableListOf(
                    getCustomSpotColor(color),
                    getCustomSpotColor(color),
                    getCustomSpotColor(color),
                    getCustomSpotColor(color),
                    getCustomSpotColor(color)
                )
            )
        }

        fun getCurrentPuzzle(): ColorRow {
            return ColorRow(
                mutableListOf(
                    getCustomSpotColor(spotColorGreen),
                    getCustomSpotColor(spotColorRed),
                    getCustomSpotColor(spotColorPurple),
                    getCustomSpotColor(spotColorYellow),
                    getCustomSpotColor(spotColorRed)
                )
            )
        }

        fun getColorRowValidated(): ColorRow {
            return ColorRow(
                mutableListOf(
                    getCustomSpotColor(spotColorGreen),
                    getCustomSpotColor(spotColorRed),
                    getCustomSpotColor(spotColorPurple),
                    getCustomSpotColor(spotColorYellow),
                    getCustomSpotColor(spotColorRed)
                ),
                mutableListOf(
                    getCustomSpotColor(spotColorClose),
                    getCustomSpotColor(spotColorDefault),
                    getCustomSpotColor(spotColorValid),
                    getCustomSpotColor(spotColorClose),
                    getCustomSpotColor(spotColorDefault)
                )
            )
        }
    }
}