package com.gillhad.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.gillhad.navigation.NavigationEvents
import com.gillhad.navigation.NavigationManager
import com.gillhad.navigation.NavigationRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val navigationManager: NavigationManager) : ViewModel() {
    private val _musicState = MutableStateFlow<Float>(100f)
    val musicState: StateFlow<Float> = _musicState.asStateFlow()

    private val _sfxState = MutableStateFlow<Float>(100f)
    val sfxState: StateFlow<Float> = _sfxState.asStateFlow()



    fun setMusicVolume(newValue: Float){

    }

    fun setSfxVolume(newValue: Float){

    }

    fun navigate(url: NavigationRoute){
        navigationManager.navigate(NavigationEvents.NavigateTo(url))
    }


}