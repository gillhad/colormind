package com.gillhad.game

import androidx.lifecycle.ViewModel
import com.gillhad.designsystem.theme.spotColorBlue
import com.gillhad.designsystem.theme.spotColorClose
import com.gillhad.designsystem.theme.spotColorDefault
import com.gillhad.designsystem.theme.spotColorGreen
import com.gillhad.designsystem.theme.spotColorPurple
import com.gillhad.designsystem.theme.spotColorRed
import com.gillhad.designsystem.theme.spotColorValid
import com.gillhad.designsystem.theme.spotColorYellow
import com.gillhad.game.models.GameScreenActions
import com.gillhad.game.models.GameScreenState
import com.gillhad.shared.enums.DifficultyLevels.EASY
import com.gillhad.shared.enums.SpotAmountLevels.FOUR_SPOTS
import com.vueling.domain.PuzzleGenerator
import com.vueling.domain.models.ColorRow
import com.vueling.domain.models.mocks.MockColorRow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(var puzzleGenerator: PuzzleGenerator) : ViewModel() {

    private val _uiState = MutableStateFlow(GameScreenState())
    var uiState: StateFlow<GameScreenState> = _uiState.asStateFlow()

    init {
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
        initState()
    }

    val actions = GameScreenActions(
        onValidateRow = ::validateRow,
        onSpotSelected = ::updateSpotSelected
    )

    private fun initState() {
        println("iniciamos el state")
        getPuzzleAmount()
        getListOfColors()
        generateNewPuzzle()
    }

    private fun getPuzzleAmount() {
        //TODO: get amount from settings
        _uiState.update {
            it.copy(amount = 4)
        }
    }

    private fun getListOfColors() {
        _uiState.value.currentColors = listOf(
            spotColorRed,
            spotColorGreen,
            spotColorBlue,
            spotColorPurple,
            spotColorYellow
        )
        //TODO: should be stored in settings
    }

    private fun generateNewPuzzle() {
        _uiState.update {
            it.copy(
                currentPuzzle = puzzleGenerator.generatePuzzle(FOUR_SPOTS, EASY),
                currentRow = puzzleGenerator.generateEmptyPuzzle(FOUR_SPOTS)

            )
        }
        _uiState.value.currentPuzzle =
            puzzleGenerator.generatePuzzle(FOUR_SPOTS, EASY)
        println(_uiState.value.currentPuzzle.spotList.size)
    }

    private fun updateSpotSelected(spot: Int) {
        if (spot == _uiState.value.spotSelected) {
            _uiState.update {
                it.copy(spotSelected = null)
            }
            _uiState.value.spotSelected = null
        } else {
            _uiState.update {
                it.copy(spotSelected = spot)
            }
        }
        println("seleccionando el spot $spot, ${_uiState.value.spotSelected}")
    }

    private fun validateRow(row: ColorRow) {}
}