package com.gillhad.game

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun GameScreenPreview() {
    val fakeData = GameScreenData(
        amount = 4
    )
    Scaffold { innerPadding ->
    GameView(Modifier.padding(innerPadding),fakeData)
    }
}