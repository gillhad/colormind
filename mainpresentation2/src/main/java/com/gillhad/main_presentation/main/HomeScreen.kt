package com.gillhad.main_presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold {innerPadding ->
    Box(Modifier.padding(innerPadding)){
        Text("VAMOOOOS")
    }
    }
}