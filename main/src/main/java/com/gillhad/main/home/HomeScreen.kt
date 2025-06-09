package com.gillhad.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gillhad.designsystem.composable.spacers.CMElevatedButton
import com.gillhad.designsystem.theme.AppTypography
import com.gillhad.main.R
import com.gillhad.navigation.NavigationRoute

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    HomeScreenContent(onNavigate = { route -> viewModel.navigate(route) })
}

@Composable
fun HomeScreenContent(onNavigate: (NavigationRoute) -> Unit) {
    Scaffold { innerPadding ->
        Box(Modifier.padding(innerPadding)){
            Column {
                Body(onNavigate)
            }
        }
    }
}

@Composable
fun Body(onNavigate: (NavigationRoute) -> Unit){
    Title()
    Logo()
    HomeOptions(onNavigate)

}

@Composable
fun Title(){
    Box(Modifier
        .fillMaxHeight(0.3f)
        .fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(stringResource(R.string.app_title), style = AppTypography.titleLarge)
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
fun HomeOptions(onNavigate: (NavigationRoute) -> Unit) {
    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(20.dp) ,horizontalAlignment = Alignment.CenterHorizontally) {
        CMElevatedButton(Modifier,"GAME") { onNavigate(NavigationRoute.GameRoute) }
        CMElevatedButton(Modifier,"GAME OPTIONS") { onNavigate(NavigationRoute.GameRoute) }
        CMElevatedButton(Modifier,"HISTORY") { onNavigate(NavigationRoute.GameRoute) }
        CMElevatedButton(Modifier,"SETTINGS") { onNavigate(NavigationRoute.GameRoute) }
    }
}

