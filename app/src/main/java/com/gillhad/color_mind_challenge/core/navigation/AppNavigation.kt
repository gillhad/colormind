package com.gillhad.color_mind_challenge.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.gillhad.color_mind_challenge.ui.main.navigation.mainNavGraph


@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(navController, HomeRoute){
        mainNavGraph(navController)
    }
}