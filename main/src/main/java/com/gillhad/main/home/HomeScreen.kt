package com.gillhad.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.gillhad.designsystem.composable.spacers.CMElevatedButton
import com.gillhad.designsystem.composable.spacers.SpacerVMedium
import com.gillhad.designsystem.theme.Spacing
import com.gillhad.main.R

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    HomeScreenContent()
}

@Composable
fun HomeScreenContent() {
    Scaffold { innerPadding ->
        Box(Modifier.padding(innerPadding)){
            Column {
                Body()
            }
        }
    }
}

@Composable
fun Body(){
    Title()
    Logo()
    HomeOptions()

}

@Composable
fun Title(){
    Box(Modifier
        .fillMaxHeight(0.3f)
        .fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(stringResource(R.string.app_title))
    }
}

@Composable
fun Logo(){
    Box(Modifier
        .fillMaxHeight(0.3f)
        .fillMaxWidth(), contentAlignment = Alignment.Center){
        Text("Aqui el logo")
    }
}

@Composable
fun HomeOptions() {
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(20.dp) ,horizontalAlignment = Alignment.CenterHorizontally) {
        CMElevatedButton(Modifier,"GAME") { }
        CMElevatedButton(Modifier,"GAME OPTIONS") { }
        CMElevatedButton(Modifier,"HISTORY") { }
        CMElevatedButton(Modifier,"SETTINGS") { }
    }
}

