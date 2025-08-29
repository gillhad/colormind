package com.gillhad.shared.models

import androidx.compose.ui.graphics.Color

data class SpotColor(
    val defaultColor: Color,
    var selectedColor: Color? = null
) {

    fun changeColor(color: Color) {
        selectedColor = color
    }
}