package com.gillhad.shared.models

import com.gillhad.designsystem.theme.spotColorDefault
import com.gillhad.designsystem.theme.spotColorGreen
import kotlinx.serialization.Serializable

@Serializable
data class ColorRow(
    val colorsList: MutableList<SpotColor>
){

companion object{
     private fun generateColorRow(spotAmount: Int, diffLevel: String): MutableList<SpotColor> {
        //TODO: add generation function
        var listOfSpots: MutableList<SpotColor> = mutableListOf()
         (0..spotAmount).map{index ->
        listOfSpots.add(SpotColor(
            spotColorGreen.toString(),
            spotColorDefault.toString()
        ))
         }

        return listOfSpots
    }
}
    constructor(spotAmount: Int, diffLevel: String) : this(
        colorsList = generateColorRow(spotAmount,diffLevel)
    )

    fun validateRow(): Boolean{
        //TODO: validate if these are the correct colors
        return true
    }

}