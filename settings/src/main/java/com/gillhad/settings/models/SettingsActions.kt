package com.gillhad.settings.models

data class SettingsActions(
    val onMusicValueChange: (Float) -> Unit,
    val onSfxValueChange: (Float) -> Unit,
    val onAccountClick: () -> Unit,
    val onTermsClick: () -> Unit,
    val onPrivacyClick: () -> Unit,
    val onContactClick: () -> Unit
)