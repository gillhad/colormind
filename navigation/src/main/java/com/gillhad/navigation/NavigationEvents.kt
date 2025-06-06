package com.gillhad.navigation

sealed class NavigationEvents {
    data class NavigateTo(val route: String): NavigationEvents()
    object NavigateBack : NavigationEvents()
}