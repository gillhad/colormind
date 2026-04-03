package com.gillhad.domain

import com.gillhad.domain.models.ColorRow
import com.gillhad.domain.models.SpotColor
import com.gillhad.shared.enums.DifficultyLevels
import com.gillhad.shared.enums.PuzzleColors
import com.gillhad.shared.enums.SpotAmountLevels
import javax.inject.Inject
import kotlin.random.Random
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class PuzzleManager @Inject constructor() {

    fun generateEmptyPuzzle(spotAmount: SpotAmountLevels): ColorRow {
        val listOfSpots: MutableList<SpotColor> = mutableListOf()
        (0..spotAmount.amount).map {
            listOfSpots.add(
                SpotColor()
            )
        }
        return ColorRow(spotList = listOfSpots.toList())
    }

    fun generatePuzzle(spotAmount: SpotAmountLevels, diffLevel: DifficultyLevels): ColorRow {
        val listOfSpots: MutableList<SpotColor> = mutableListOf()
        (0..spotAmount.amount).map { index ->
            listOfSpots.add(
                SpotColor(
                    getRandomColor(diffLevel)
                )
            )
        }
        println("puzzle nuevo generado: $listOfSpots")
        return ColorRow(spotList = listOfSpots.toList())
    }

    fun getColorsByDifficulty(difficultyLevels: DifficultyLevels): List<PuzzleColors> {
        return PuzzleColors.getPuzzleColor().take(difficultyLevels.colorAmount)
    }

    @OptIn(ExperimentalTime::class)
    fun getRandomColor(difficultyLevels: DifficultyLevels): PuzzleColors {
        val colors = getColorsByDifficulty(difficultyLevels)
        var randomNumber = Clock.System.now().epochSeconds
        randomNumber /= Random.nextInt(2, 5)
        val index = (randomNumber % colors.size).toInt()
        return colors[index]
    }

    fun validateRow(rowToValidate: ColorRow, puzzle: ColorRow): List<SpotColor> {
        val guessSpots = rowToValidate.spotList
        val puzzleSpots = puzzle.spotList
        val puzzleFrequency = puzzleSpots
            .groupingBy { it.selectedColor }
            .eachCount()
            .toMutableMap()

        var validMatches = 0
        var closeMatches = 0

        guessSpots.forEachIndexed { index, spot ->
            if (spot.selectedColor == puzzleSpots[index].selectedColor) {
                validMatches++
                puzzleFrequency[spot.selectedColor] = puzzleFrequency[spot.selectedColor]!! - 1
            }
        }

        guessSpots.forEachIndexed { index, spot ->
            if (spot.selectedColor != puzzleSpots[index].selectedColor) {
                val count = puzzleFrequency.getOrDefault(spot.selectedColor, 0)
                if (count > 0) {
                    closeMatches++
                    puzzleFrequency[spot.selectedColor] = count - 1
                }
            }
        }

        return buildList {
            repeat(validMatches) { add(SpotColor(PuzzleColors.VALID)) }
            repeat(closeMatches) { add(SpotColor(PuzzleColors.CLOSE)) }

            val remaining = guessSpots.size - this.size
            repeat(remaining) { add(SpotColor()) }
        }
    }
}