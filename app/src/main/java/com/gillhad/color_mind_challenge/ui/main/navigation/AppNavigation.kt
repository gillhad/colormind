package com.gillhad.color_mind_challenge.ui.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.gillhad.main.home.mainNavGraph
import com.gillhad.navigation.HomeRoute
import com.gillhad.navigation.NavigationEvents
import com.gillhad.navigation.NavigationManager


@Composable
fun AppNavigation(navController: NavHostController, navigationManager: NavigationManager){
    LaunchedEffect(Unit) {
        navigationManager.navigationEvents.collect { event ->
            when (event) {
                is NavigationEvents.NavigateTo -> {
                    navController.navigate(event.route) {
                    }
                }
                is NavigationEvents.NavigateBack -> {
                    navController.popBackStack()
                }
            }
        }
    }

    NavHost(navController, HomeRoute){
        mainNavGraph(navController)
    }
}