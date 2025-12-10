package com.gillhad.game.models

sealed class GameScreenEvents {
    data object OnSpotSelected : GameScreenEvents()
    data class OnSomething(val index: Int) : GameScreenEvents()
}
