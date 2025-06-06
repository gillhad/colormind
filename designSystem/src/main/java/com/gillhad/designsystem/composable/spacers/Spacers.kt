package com.gillhad.designsystem.composable.spacers

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gillhad.designsystem.theme.Spacing

@Composable
fun SpacerVXSmall(){
    Spacer(Modifier.height(Spacing.xSmall))
}

@Composable
fun SpacerVSmall(){
    Spacer(Modifier.height(Spacing.small))
}

@Composable
fun SpacerVMedium(){
    Spacer(Modifier.height(Spacing.medium))
}

@Composable
fun SpacerVLarge(){
    Spacer(Modifier.height(Spacing.large))
}

@Composable
fun SpacerVXLarge(){
    Spacer(Modifier.height(Spacing.xLarge))
}

@Composable
fun SpacerVXXLarge(){
    Spacer(Modifier.height(Spacing.xxLarge))
}


@Composable
fun SpacerHXSmall(){
    Spacer(Modifier.width(Spacing.xSmall))
}

@Composable
fun SpacerHSmall(){
    Spacer(Modifier.width(Spacing.small))
}

@Composable
fun SpacerHMedium(){
    Spacer(Modifier.width(Spacing.medium))
}

@Composable
fun SpacerHLarge(){
    Spacer(Modifier.width(Spacing.large))
}

@Composable
fun SpacerHxLarge(){
    Spacer(Modifier.width(Spacing.xLarge))
}

@Composable
fun SpacerHxxLarge(){
    Spacer(Modifier.width(Spacing.xxLarge))
}




