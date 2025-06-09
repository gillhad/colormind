package com.gillhad.color_mind_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.gillhad.designsystem.theme.ColorMindTheme
import com.gillhad.color_mind_challenge.ui.main.navigation.AppNavigation
import com.gillhad.navigation.NavigationManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigationManager: NavigationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorMindTheme {
                val controller = rememberNavController()
                AppNavigation(controller,navigationManager)
            }
        }
    }
}

