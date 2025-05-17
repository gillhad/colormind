package com.gillhad.color_mind_challenge.core.navigation

sealed class NavigationEvents {
    object toHome : NavigationEvents()
    object toGame : NavigationEvents()
    object toSettings : NavigationEvents()
    object toHistory : NavigationEvents()
    object toGameMode : NavigationEvents()
}