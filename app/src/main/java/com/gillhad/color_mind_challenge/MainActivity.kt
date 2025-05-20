package com.gillhad.color_mind_challenge

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.app.AppLocalesStorageHelper
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.gillhad.color_mind_challenge.core.navigation.AppNavigation
import com.gillhad.color_mind_challenge.ui.theme.ColorMindTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorMindTheme {
                val controller = rememberNavController()
                    AppNavigation(controller)
            }
        }
    }
}

