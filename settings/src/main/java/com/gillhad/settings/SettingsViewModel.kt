package com.gillhad.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {
    val _musicState = mutableStateOf<Int>(100)

    val _sfxState = mutableStateOf<Int>(100)


    fun setMusicVolume(){

    }

    fun setSfxVolume(){

    }


}