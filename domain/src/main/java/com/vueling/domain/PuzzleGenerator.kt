package com.vueling.domain

import com.gillhad.designsystem.theme.spotColorDefault
import com.gillhad.designsystem.theme.spotColorGreen
import com.gillhad.shared.enums.DifficultyLevels
import com.gillhad.shared.enums.PuzzleColors
import com.gillhad.shared.enums.SpotAmountLevels
import com.vueling.domain.models.ColorRow
import com.vueling.domain.models.SpotColor
import javax.inject.Inject
import kotlin.random.Random
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class PuzzleGenerator @Inject constructor() {

    fun generateEmptyPuzzle(spotAmount: SpotAmountLevels): ColorRow {
        val listOfSpots: MutableList<SpotColor> = mutableListOf()
        (0..spotAmount.amount).map { index ->
            listOfSpots.add(
                SpotColor(
                    spotColorDefault,
                    spotColorDefault
                )
            )
        }
        return ColorRow(spotList = listOfSpots.toList())
    }

    fun generatePuzzle(spotAmount: SpotAmountLevels, diffLevel: DifficultyLevels): ColorRow {
        val listOfSpots: MutableList<SpotColor> = mutableListOf()
        (0..spotAmount.amount).map { index ->
            listOfSpots.add(
                SpotColor(
                    spotColorGreen,
                    getRandomColor(diffLevel).color
                )
            )
        }
        return ColorRow(spotList = listOfSpots.toList())
    }

    fun getColorsByDifficulty(difficultyLevels: DifficultyLevels): List<PuzzleColors> {
        return PuzzleColors.getPuzzleColor().take(difficultyLevels.colorAmount)
    }

    @OptIn(ExperimentalTime::class)
    fun getRandomColor(difficultyLevels: DifficultyLevels): PuzzleColors {
        val colors = getColorsByDifficulty(difficultyLevels)
        var randomNumber = Clock.System.now().epochSeconds
        randomNumber = randomNumber / Random.nextInt(2, 5)
        val index = (randomNumber % colors.size).toInt()
        return colors[index]
    }
}