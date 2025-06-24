@file:OptIn(ExperimentalMaterial3Api::class)

package com.gillhad.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.gillhad.designsystem.composable.spacers.CMSlider
import com.gillhad.designsystem.composable.spacers.SpacerVXLarge
import com.gillhad.designsystem.theme.Spacing
import com.gillhad.settings.composable.SettingsOption
import com.gillhad.settings.models.SettingsActions
import com.gillhad.shared.R

@Composable
fun SettingsScreen(settingsViewModel: SettingsViewModel){
    val musicsSliderState = settingsViewModel.musicState.collectAsState()
    val sfxSliderState = settingsViewModel.sfxState.collectAsState()
    val sliderStateList = remember { mutableStateListOf<SliderState>(SliderState(value = musicsSliderState.value),SliderState(value = sfxSliderState.value)) }

    val actions = remember(settingsViewModel) {
        SettingsActions(
            onMusicValueChange = { newValue -> settingsViewModel.setMusicVolume(newValue) },
            onSfxValueChange = { newValue -> settingsViewModel.setSfxVolume(newValue) },
            onAccountClick = {  },
            onTermsClick = {  },
            onPrivacyClick = { },
            onContactClick = {  }
        )
    }

    Scaffold(topBar = { CurrentTopBar() }) { innerPadding ->
        Body(Modifier.padding(innerPadding),sliderStateList,actions)
    }
}

@Composable
fun CurrentTopBar(){
    TopAppBar(title = { Text(stringResource(R.string.settings)) }, Modifier)
}

@Composable
fun Body(
    modifier: Modifier,
    states:MutableList<SliderState>,
    settingsActions: SettingsActions){

        Box(modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = Spacing.xLarge)){
            Column(Modifier.fillMaxWidth()) {
                CMSlider("Music",states[0]){}
                CMSlider("Sound",states[1]){}
                SpacerVXLarge()
                SettingsOption(R.string.account){println("click")}
                SettingsOption(R.string.terms){println("click")}
                SettingsOption(R.string.privacy){println("click")}
                SettingsOption(R.string.contact){println("click")}
            }
        }

}