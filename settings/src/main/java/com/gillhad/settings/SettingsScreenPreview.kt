package com.gillhad.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gillhad.settings.models.SettingsActions

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    val musicsSliderState = SliderState(value = 100f)
    val vfxSliderState = SliderState(value = 100f)
    val sliderStateList = remember { mutableStateListOf<SliderState>(musicsSliderState, vfxSliderState) }
    val settingsActions = SettingsActions(
        onMusicValueChange = {},
        onSfxValueChange = {},
        onAccountClick = {},
        onTermsClick = {},
        onPrivacyClick = {},
        onContactClick = {}
    )
    Body(Modifier.padding(), sliderStateList, settingsActions)
}
