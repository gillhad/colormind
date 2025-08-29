package com.gillhad.shared.models

import com.gillhad.designsystem.theme.spotColorDefault
import com.gillhad.designsystem.theme.spotColorGreen

data class ColorRow(
    val spotList: MutableList<SpotColor>,
    val validationList: MutableList<SpotColor>? = null
) {

    companion object {

        private fun generateColorRow(spotAmount: Int, diffLevel: String): MutableList<SpotColor> {
            //TODO: add generation function
            var listOfSpots: MutableList<SpotColor> = mutableListOf()
            (0..spotAmount).map { index ->
                listOfSpots.add(
                    SpotColor(
                        spotColorGreen,
                        spotColorDefault
                    )
                )
            }

            return listOfSpots
        }
    }

    constructor(spotAmount: Int, diffLevel: String) : this(
        spotList = generateColorRow(spotAmount, diffLevel)
    )

    fun validateRow(): Boolean {
        //TODO: validate if these are the correct colors
        return true
    }

    fun isValidated() : Boolean{
        return validationList != null
    }
}