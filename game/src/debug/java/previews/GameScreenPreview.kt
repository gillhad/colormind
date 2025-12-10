package previews

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gillhad.designsystem.theme.spotColorBlue
import com.gillhad.designsystem.theme.spotColorClose
import com.gillhad.designsystem.theme.spotColorDefault
import com.gillhad.designsystem.theme.spotColorGreen
import com.gillhad.designsystem.theme.spotColorPurple
import com.gillhad.designsystem.theme.spotColorRed
import com.gillhad.designsystem.theme.spotColorValid
import com.gillhad.designsystem.theme.spotColorYellow
import com.gillhad.game.GameView
import com.gillhad.game.models.GameScreenActions
import com.gillhad.game.models.GameScreenState
import com.vueling.domain.models.mocks.MockColorRow

@Preview
@Composable
fun GameScreenPreview() {
    val fakeData = GameScreenState(
        amount = 4,
        listColorRows = mutableListOf(MockColorRow.getColorRowValidated(), MockColorRow.getColorRowValidated()),
        currentRow = MockColorRow.getCustomColorRowMock(spotColorDefault),
        currentPuzzle = MockColorRow.getCurrentPuzzleMock(),
        currentColors = listOf(
            spotColorRed,
            spotColorGreen,
            spotColorBlue,
            spotColorPurple,
            spotColorYellow,
            spotColorClose,
            spotColorValid,
        ),
        spotSelected = 1
    )
    val fakeState = GameScreenActions(
        onValidateRow = {},
        onSpotSelected = { }
    )
    Scaffold { innerPadding ->
        GameView(Modifier.padding(innerPadding), fakeData, fakeState)
    }
}