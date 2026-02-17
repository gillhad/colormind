package com.gillhad.shared.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints

@Composable
fun OverflowBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier.graphicsLayer(clip = false),
        content = content
    ) { measurables, constraints ->
        val placeable = measurables.first().measure(Constraints())
        layout(0, 0) {
            placeable.placeRelative(
                x = (constraints.maxWidth - placeable.width) / 2,
                y = (constraints.maxHeight - placeable.height) / 2
            )
        }
    }
}