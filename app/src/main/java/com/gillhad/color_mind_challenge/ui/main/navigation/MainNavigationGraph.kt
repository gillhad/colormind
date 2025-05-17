package com.gillhad.color_mind_challenge.ui.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gillhad.color_mind_challenge.core.navigation.GameModeRoute
import com.gillhad.color_mind_challenge.core.navigation.GameRoute
import com.gillhad.color_mind_challenge.core.navigation.HistoryRoute
import com.gillhad.color_mind_challenge.core.navigation.HomeRoute
import com.gillhad.color_mind_challenge.core.navigation.SettingsRoute
import com.gillhad.color_mind_challenge.ui.main.screens.home.HomeScreen

fun NavGraphBuilder.mainNavGraph(navHostController: NavHostController){
    composable<HomeRoute>{
        HomeScreen()
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