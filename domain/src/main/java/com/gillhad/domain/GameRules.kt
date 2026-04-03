package com.gillhad.domain

import com.gillhad.domain.models.ColorRow

class GameRules(val maxAttempts: Int = 5) {

    fun hasLostGame(currentAttempts: Int): Boolean = currentAttempts >= maxAttempts
    fun hasWinGame(puzzleAtempt: ColorRow, puzzleSolution: ColorRow): Boolean {
        puzzleAtempt.spotList.forEachIndexed { index, color ->
            print("comparamos ${puzzleSolution.spotList[index].selectedColor} ${color.selectedColor}")
            puzzleSolution.spotList[index].selectedColor == color.selectedColor
        }
        println("el intento ha ganado?")
        print(puzzleAtempt.spotList.zip(puzzleSolution.spotList).all { (color1, color2) -> color1 == color2 })
        return puzzleAtempt.spotList.zip(puzzleSolution.spotList).all { (color1, color2) -> color1 == color2 }
    }

    fun canMakeAttempt(currentAttempts: Int): Boolean = !hasLostGame(currentAttempts)

    fun attemptsRemaining(currentAttempts: Int): Int = maxOf(0, maxAttempts - currentAttempts)

    fun isLastAttempt(currentAttempts: Int): Boolean = attemptsRemaining(currentAttempts) == 1
}
