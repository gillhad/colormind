package com.gillhad.game

import androidx.lifecycle.ViewModel
import com.gillhad.domain.GameRules
import com.gillhad.domain.PuzzleManager
import com.gillhad.domain.repositories.PreferenceRepository
import com.gillhad.game.models.GameScreenActions
import com.gillhad.game.models.GameScreenState
import com.gillhad.shared.enums.DifficultyLevels.EASY
import com.gillhad.shared.enums.PuzzleColors
import com.gillhad.shared.enums.SpotAmountLevels.FOUR_SPOTS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    var puzzleManager: PuzzleManager,
    private val preferenceRepository: PreferenceRepository
) : ViewModel() {

    private val maxAttempts: Int
        get() = preferenceRepository.getInt("max_attempts")

    private val gameRules: GameRules by lazy { GameRules(2) }

    private val _uiState = MutableStateFlow(GameScreenState())
    var uiState: StateFlow<GameScreenState> = _uiState.asStateFlow()

    init {
        initState()
    }

    val actions = GameScreenActions(
        onValidateRow = ::validateRow,
        onSpotSelected = ::updateSpotSelected,
        onColorSelected = ::updateColorSelected,
        manageWinDialog = ::wonGame,
        resetGame = ::resetGame,
        backToMenu = {}
    )

    private fun initState() {
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
            PuzzleColors.RED,
            PuzzleColors.BLUE,
            PuzzleColors.PURPLE,
            PuzzleColors.GREEN,
            PuzzleColors.YELLOW
        )
        //TODO: should be stored in settings
    }

    private fun generateNewPuzzle() {
        _uiState.update {
            it.copy(
                currentPuzzle = puzzleManager.generatePuzzle(FOUR_SPOTS, EASY),
                currentRow = puzzleManager.generateEmptyPuzzle(FOUR_SPOTS)

            )
        }
    }

    private fun updateSpotSelected(spot: Int?) {
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
    }

    private fun updateColorSelected(color: PuzzleColors) {
        val spotSelected = _uiState.value.spotSelected
        if (spotSelected != null) {
            val currentRow = _uiState.value.currentRow
            currentRow.spotList[spotSelected].selectedColor = color
            _uiState.update {
                it.copy(
                    currentRow = currentRow,
                    spotSelected = null
                )
            }
        }
    }

    private fun validateRow() {
        if (!checkAllSpotsFilled()) {
            println("no has puesto colores")
            //TODO: when one is no filled, add some UI indication, color shake, toast, etc
            return
        }
        println(
            "size de listcolors al inicio ${_uiState.value.listColorRows.size}"
        )
        val row = _uiState.value.currentRow
        val validatedRow = puzzleManager.validateRow(row, _uiState.value.currentPuzzle)
        row.validationList.addAll(validatedRow)
        val updatedList = _uiState.value.listColorRows + row
        _uiState.update {
            it.copy(
                listColorRows = updatedList,
                currentRow = puzzleManager.generateEmptyPuzzle(FOUR_SPOTS)
            )
        }
        println(
            "size de listcolors ${_uiState.value.listColorRows.size}"
        )
        isGameFinished()
    }

    //Check if user hass added all the colors to the current row
    private fun checkAllSpotsFilled(): Boolean {
        _uiState.value.currentRow.spotList.forEach { spot ->
            if (spot.selectedColor == PuzzleColors.DEFAULT) {
                return false
            }
        }
        //TODO: add some UI indication that not all spots are filled
        return true
    }

    private fun isGameFinished() {
        println("atempts que tenemos: ${_uiState.value.attempts}")
        _uiState.update {
            it.copy(attempts = it.attempts + 1)
        }
        if (gameRules.hasWinGame(_uiState.value.listColorRows.last(), _uiState.value.currentPuzzle)) {
            wonGame()
        } else if (gameRules.hasLostGame(_uiState.value.attempts)) {
            println("pues hemos perdido el game")
            lostGame()
        }
    }

    private fun wonGame() {
        _uiState.update {
            it.copy(
                uiState = it.uiState.copy(showWinDialog = !it.uiState.showWinDialog),
                hasWon = true
            )
        }
        initState()
    }

    private fun resetGame() {
        generateNewPuzzle()
        _uiState.update {
            it.copy(
                uiState = it.uiState.copy(
                    showWinDialog = false,
                    showLostDialog = false,
                ),
                hasLost = false,
                hasWon = false,
                attempts = 0,
                listColorRows = emptyList()
            )
        }
    }

    private fun lostGame() {
        _uiState.update {
            it.copy(
                hasLost = true,
                uiState = it.uiState.copy(showLostDialog = !it.uiState.showLostDialog)
            )
        }
    }
}