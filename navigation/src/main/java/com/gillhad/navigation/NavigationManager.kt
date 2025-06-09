package com.gillhad.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NavigationManager @Inject constructor() {
    private val _navigationEvents = MutableSharedFlow<NavigationEvents>(extraBufferCapacity = 1)
    val navigationEvents: SharedFlow<NavigationEvents> = _navigationEvents.asSharedFlow()

    fun navigate(events: NavigationEvents){
        _navigationEvents.tryEmit(events)
    }
}