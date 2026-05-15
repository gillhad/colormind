package com.gillhad.designsystem.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import com.gillhad.designsystem.composable.spacers.SpacerHMedium
import com.gillhad.designsystem.composable.spacers.SpacerHSmall
import com.gillhad.designsystem.theme.BoxSize
import com.gillhad.designsystem.theme.ElevationSize
import com.gillhad.designsystem.theme.PaddingSize
import com.gillhad.designsystem.theme.backgroundLight
import com.gillhad.designsystem.theme.onSurfaceVariantLight
import com.gillhad.designsystem.theme.primaryContainerDark

@Composable
fun ValueAdjusterButtons(currentValue: Int, range: IntRange, onValueChange: (Int) -> Unit) {
    var initValue by remember { mutableIntStateOf(currentValue) }
    Row(
        Modifier.padding(horizontal = PaddingSize.paddingM, vertical = PaddingSize.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AdjusterButton(false, initValue, range) {
            initValue = (currentValue - 1).coerceAtLeast(range.first)
            onValueChange(initValue)
        }
        SpacerHSmall()
        Box(
            Modifier
                .size(BoxSize.mediumBox)
                .shadow(ElevationSize.elevationL, shape = CircleShape)
                .background(backgroundLight, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) { Text(initValue.toString()) }
        SpacerHMedium()
        AdjusterButton(true, initValue, range) {
            initValue = (currentValue + 1).coerceAtMost(range.last)
            onValueChange(initValue)
        }
    }
}

@Composable
fun AdjusterButton(isAdder: Boolean, currentValue: Int, intRange: IntRange, action: () -> Unit) {
    var isLastValue by remember { mutableStateOf(false) }

    LaunchedEffect(currentValue) {
        isLastValue = if (isAdder) intRange.last == currentValue else intRange.first == currentValue
    }

    Box(
        Modifier
            .size(BoxSize.mediumBox)
            .shadow(ElevationSize.elevationL, shape = CircleShape)
            .background(if (isLastValue) onSurfaceVariantLight else backgroundLight, shape = CircleShape)
            .clickable(
                enabled = !isLastValue,
                onClick = {
                    action()
                }

            )

    ) {
        Icon(
            modifier = Modifier,
            imageVector = if (isAdder) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = primaryContainerDark
        )
    }
}

///MIRANDO DE USAR EL ENUM O EL GENERICO
// QUe el nivel de dificultad devuelva valores por defecto y añadir un custom con selector variado de colores y cantidad de huecos??

@Composable
fun <T : Enum<T>> EnumAdjusterButtons(
    currentValue: T,
    values: Array<T>,
    onValueChange: (T) -> Unit
) {
    var initValue by remember { mutableStateOf(currentValue) }
    Row(
        Modifier.padding(horizontal = PaddingSize.paddingM, vertical = PaddingSize.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AdjusterButton(false, initValue.ordinal, values.indices) {
            val newIndex = (initValue.ordinal - 1).coerceAtLeast(values.indices.first)
            initValue = values[newIndex]
            onValueChange(initValue)
        }
        SpacerHSmall()
        Box(
            Modifier
                .size(BoxSize.mediumBox)
                .shadow(ElevationSize.elevationL, shape = CircleShape)
                .background(backgroundLight, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) { Text(initValue.name) }
        SpacerHMedium()
        AdjusterButton(true, initValue.ordinal, values.indices) {
            val newIndex = (initValue.ordinal + 1).coerceAtMost(values.indices.last)
            initValue = values[newIndex]
            onValueChange(initValue)
        }
    }
}
