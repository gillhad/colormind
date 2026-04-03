package previews

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.gillhad.game.GameView
import com.gillhad.game.models.GameScreenActions
import com.gillhad.game.models.GameScreenState
import com.gillhad.shared.enums.PuzzleColors
import com.gillhad.domain.models.mocks.MockColorRow

@Preview
@Composable
fun GameScreenPreview() {
    val fakeData = GameScreenState(
        amount = 4,
        listColorRows = mutableListOf(MockColorRow.getColorRowValidated(), MockColorRow.getColorRowValidated()),
        currentRow = MockColorRow.getCustomColorRowMock(PuzzleColors.DEFAULT),
        currentPuzzle = MockColorRow.getCurrentPuzzleMock(),
        currentColors = listOf(
            PuzzleColors.RED,
            PuzzleColors.PURPLE,
            PuzzleColors.GREEN,
            PuzzleColors.YELLOW,
            PuzzleColors.BLUE
        ),
        spotSelected = 1
    )
    val fakeState = GameScreenActions(
        onValidateRow = {},
        onSpotSelected = { },
        onColorSelected = {},
        manageWinDialog = {},
        resetGame = {},
        backToMenu = {}
    )
    Scaffold { innerPadding ->
        GameView(context = LocalContext.current, Modifier.padding(innerPadding), fakeData, fakeState)
    }
}