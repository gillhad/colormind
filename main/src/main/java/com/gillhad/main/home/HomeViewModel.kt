package com.gillhad.main.home

import androidx.lifecycle.ViewModel
import com.gillhad.navigation.NavigationEvents
import com.gillhad.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val navigationManager: NavigationManager) : ViewModel() {

    fun navigate(event: NavigationEvents){
        navigationManager.navigate(event)
    }
}