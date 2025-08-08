package com.gillhad.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gillhad.shared.models.ColorRow

class GameScreenData(
    val amount: Int
    )


@Composable
fun GameScreen (gameViewModel: GameViewModel) {
    val data = GameScreenData(
        amount = 4
    )
    var currentRow: ColorRow = ColorRow(data.amount,"")
    Scaffold { innerPadding ->
        GameView(Modifier.padding(innerPadding),data)
    }
}

@Composable
fun GameView(modifier: Modifier, data: GameScreenData){
    Body(data)
}

@Composable
private fun Body(amount: GameScreenData){
    Column(Modifier.fillMaxWidth().fillMaxHeight()) {
        Header()
        ColorsView()
        ColorSelector()
        ColorPaletteSelector()
    }
}

@Composable
private fun Header(){

}

@Composable
private fun ColorsView(){
    Column(Modifier.fillMaxWidth(0.5f)) {  }
}

@Composable
private fun ColorSelector(){

}

@Composable
private fun ColorPaletteSelector(){

}