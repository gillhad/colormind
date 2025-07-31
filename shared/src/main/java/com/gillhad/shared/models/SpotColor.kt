package com.gillhad.shared.models

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

@Serializable
data class SpotColor(
    val defaultColor: String,
    var selectedColor: String
){
    fun changeColor(color:String){
        selectedColor = color
    }
}