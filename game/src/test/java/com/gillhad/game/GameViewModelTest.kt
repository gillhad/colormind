package com.gillhad.game

import com.gillhad.domain.PuzzleManager
import com.gillhad.domain.models.mocks.MockColorRow
import com.gillhad.domain.repositories.PreferenceRepository
import com.gillhad.shared.enums.PuzzleColors
import io.mockk.*
import io.mockk.impl.annotations.*
import org.junit.*
import org.junit.Assert.*

class GameViewModelTest {

    lateinit var viewmodel: GameViewModel

    @RelaxedMockK
    lateinit var puzzleManager: PuzzleManager

    @RelaxedMockK
    lateinit var preferenceRepository: PreferenceRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewmodel = GameViewModel(
            puzzleManager, preferenceRepository
        )

        viewmodel.uiState.value.currentPuzzle = MockColorRow.getCurrentPuzzleMock()
        viewmodel.uiState.value.currentRow = MockColorRow.getDifferentPuzzleMock()
        every { preferenceRepository.getInt("max_attempts") } returns 5
        println("uiState: ${viewmodel.uiState.value.currentRow.spotList}")
    }

    @Test
    fun `init should initialize state correctly`() {

        // Assert
        val uiState = viewmodel.uiState.value
        assertEquals(4, uiState.amount) // Verifica el valor inicializado en getPuzzleAmount
        assertEquals(
            listOf(
                PuzzleColors.RED,
                PuzzleColors.BLUE,
                PuzzleColors.PURPLE,
                PuzzleColors.GREEN,
                PuzzleColors.YELLOW
            ),
            uiState.currentColors
        )
        assertNotNull(uiState.currentPuzzle)
        assertNotNull(uiState.currentRow)
    }

    @Test
    fun `select color on spot`() {
        viewmodel.actions.onSpotSelected(0)

        assertNotNull(viewmodel.uiState.value.spotSelected)

        viewmodel.actions.onColorSelected(PuzzleColors.RED)

        assertEquals(PuzzleColors.RED, viewmodel.uiState.value.currentRow.spotList[0].selectedColor)
        assertNull(viewmodel.uiState.value.spotSelected)
    }

    @Test
    fun `if after review is won, show dialog for win`() {
        viewmodel.uiState.value.currentPuzzle = MockColorRow.getCurrentPuzzleMock()
        viewmodel.uiState.value.currentRow = MockColorRow.getColorRowValidated()

        viewmodel.actions.onValidateRow()

        assertTrue(viewmodel.uiState.value.uiState.showWinDialog)
    }

    @Test
    fun `if after review is lost, show dialog for lost`() {
        viewmodel.uiState.value.currentPuzzle = MockColorRow.getCurrentPuzzleMock()
        viewmodel.uiState.value.currentRow = MockColorRow.getDifferentPuzzleMock()
        viewmodel.uiState.value.attempts = 6
        viewmodel.actions.onValidateRow()

        assertTrue(viewmodel.uiState.value.uiState.showLostDialog)
    }

    @Test
    fun `resetGame`() {
        viewmodel.uiState.value.currentPuzzle = MockColorRow.getCurrentPuzzleMock()
        viewmodel.uiState.value.currentRow = MockColorRow.getColorRowValidated()

        viewmodel.actions.resetGame()
        val currentViewState = viewmodel.uiState.value

        assertFalse("Lost dialog should not be shown", currentViewState.uiState.showLostDialog)
        assertFalse("Win dialog should not be shown", currentViewState.uiState.showWinDialog)
        assertEquals("Attempts should be reset to 0", 0, currentViewState.attempts)
        assertTrue("List of color rows should be empty", currentViewState.listColorRows.isEmpty())
    }
}