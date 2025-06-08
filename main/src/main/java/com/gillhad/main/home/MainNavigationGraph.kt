package com.gillhad.main.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gillhad.navigation.NavigationRoute


fun NavGraphBuilder.mainNavGraph(navHostController: NavHostController){
    composable<NavigationRoute.HomeRoute>{
        HomeScreen(
            viewModel = hiltViewModel()
        )
    }
    composable<NavigationRoute.GameRoute>{

    }
    composable<NavigationRoute.GameModeRoute>{

    }
    composable<NavigationRoute.SettingsRoute>{

    }
    composable<NavigationRoute.HistoryRoute>{

    }
}