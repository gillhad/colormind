package com.gillhad.main.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gillhad.navigation.GameModeRoute
import com.gillhad.navigation.GameRoute
import com.gillhad.navigation.HistoryRoute
import com.gillhad.navigation.HomeRoute
import com.gillhad.navigation.SettingsRoute


fun NavGraphBuilder.mainNavGraph(navHostController: NavHostController){
    composable<HomeRoute>{
        HomeScreen(
            viewModel = hiltViewModel()
        )
    }
    composable<GameRoute>{

    }
    composable<GameModeRoute>{

    }
    composable<SettingsRoute>{

    }
    composable<HistoryRoute>{

    }
}