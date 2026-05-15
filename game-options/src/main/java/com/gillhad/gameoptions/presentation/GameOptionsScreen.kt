package com.gillhad.gameoptions.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gillhad.designsystem.composable.ValueAdjusterButtons
import com.gillhad.designsystem.theme.PaddingSize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameOptionsScreen() {
    Scaffold(
        topBar = { TopAppBar({ Text("Opciones del juego") }) }
    ) { innerPadding ->
        GameOptionsView(Modifier.padding(innerPadding))
    }
}

@Composable
fun GameOptionsView(modifier: Modifier) {
    Column(modifier.fillMaxWidth()) {
        SetDifficulty()
        SetColors()
    }
}

@Composable
fun SetDifficulty() {
    //TODO: Cambiar el valor inicial a lo que se tenga guardado en las preferencias
    var currentValue by remember { mutableStateOf(4) }
    fun updateValue(newValue: Int) {
        currentValue = newValue
    }
    Box(Modifier.padding(horizontal = PaddingSize.paddingL)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Numero de esferas")
            Spacer(Modifier.weight(1f))
            ValueAdjusterButtons(currentValue, 3..5) { updateValue(it) }
        }
    }
}

@Composable
fun SetColors() {

}

