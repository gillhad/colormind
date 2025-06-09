package com.gillhad.navigation

import com.gillhad.shared.AppConstants
import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationRoute {
    abstract val route: String

    @Serializable
    object HomeRoute : NavigationRoute() {
        override val route: String = AppConstants.HOME
    }

    @Serializable
    object GameRoute : NavigationRoute() {
        override val route: String = AppConstants.GAME
    }

    @Serializable
    object GameModeRoute : NavigationRoute() {
        override val route: String = AppConstants.GAME_MODE
    }

    @Serializable
    object SettingsRoute : NavigationRoute() {
        override val route: String = AppConstants.SETTINGS
    }

    @Serializable
    object HistoryRoute : NavigationRoute() {
        override val route: String = AppConstants.HISTORY
    }
}