package com.vueling.domain.models

data class ColorRow(
    val spotList: List<SpotColor>,
    val validationList: MutableList<SpotColor>? = null
) {

    fun validateRow(): Boolean {
        //TODO: validate if these are the correct colors
        return true
    }

    fun isValidated(): Boolean {
        return validationList != null
    }
}