package com.gillhad.navigation

sealed class NavigationEvents {
    data class NavigateTo(val route: NavigationRoute): NavigationEvents()
    object NavigateBack : NavigationEvents()
}