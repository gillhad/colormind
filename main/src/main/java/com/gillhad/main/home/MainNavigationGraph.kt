package com.gillhad.main.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gillhad.game.GameScreen
import com.gillhad.navigation.NavigationRoute
import com.gillhad.settings.SettingsScreen


fun NavGraphBuilder.mainNavGraph(navHostController: NavHostController){
    composable<NavigationRoute.HomeRoute>{
        HomeScreen(
            homeViewModel = hiltViewModel()
        )
    }
    composable<NavigationRoute.GameRoute>{
        GameScreen()
    }
    composable<NavigationRoute.GameModeRoute>{

    }
    composable<NavigationRoute.SettingsRoute>{
        SettingsScreen(
            settingsViewModel = hiltViewModel())
    }
    composable<NavigationRoute.HistoryRoute>{

    }
}