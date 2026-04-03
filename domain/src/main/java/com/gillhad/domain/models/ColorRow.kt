package com.gillhad.domain.models

data class ColorRow(
    val spotList: List<SpotColor>,
    val validationList: MutableList<SpotColor> = mutableListOf()
) {

    fun validateRow(): Boolean {
        //TODO: validate if these are the correct colors
        return true
    }

    fun isValidated(): Boolean {
        return validationList != null
    }

    override fun toString(): String {
        val colors = mutableListOf<String>()
        spotList.map { colors.add(it.selectedColor.name) }
        return colors.toString()
    }
}