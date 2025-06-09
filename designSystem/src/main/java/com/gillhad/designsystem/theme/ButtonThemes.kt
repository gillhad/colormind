package com.gillhad.designsystem.theme

import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.staticCompositionLocalOf


val lightButtonColors = ButtonColors(
        containerColor = primaryContainerLight,
        contentColor = onPrimaryContainerLight,
        disabledContainerColor = primaryContainerLight.copy(alpha = 0.6f),
        disabledContentColor = onPrimaryContainerLight.copy(alpha = 0.6f)
    )

    val LocalButtonColor = staticCompositionLocalOf { lightButtonColors }