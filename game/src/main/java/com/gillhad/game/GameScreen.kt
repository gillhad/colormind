package com.gillhad.game

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import com.gillhad.designsystem.composable.spacers.CMElevatedButton
import com.gillhad.designsystem.composable.spacers.SpacerHXxSmall
import com.gillhad.designsystem.theme.BorderSize
import com.gillhad.designsystem.theme.BoxSize
import com.gillhad.designsystem.theme.Spacing
import com.gillhad.designsystem.theme.outlineDark
import com.gillhad.designsystem.theme.secondaryDark
import com.gillhad.domain.models.ColorRow
import com.gillhad.domain.models.SpotColor
import com.gillhad.game.models.GameScreenActions
import com.gillhad.game.models.GameScreenState
import com.gillhad.shared.R
import com.gillhad.shared.composables.OverflowBox
import com.gillhad.shared.enums.PuzzleColors
import com.gillhad.shared.enums.ScreenStates

@Composable
fun GameScreen(gameViewModel: GameViewModel) {
    val state by gameViewModel.uiState.collectAsState()
    val actions = gameViewModel.actions

    val context = LocalContext.current

    Scaffold { padding ->
        when (state.uiState.screenStates) {
            ScreenStates.LOADING -> {}
            else -> GameView(context, Modifier.padding(padding), state, actions)
        }
    }
}

@Composable
fun GameView(context: Context, modifier: Modifier, state: GameScreenState, actions: GameScreenActions) {
    if (state.uiState.showWinDialog) {
        GameDialogs().AcceptDialog(
            bodyText = "has ganado"
        ) {
            actions.resetGame()
        }
    }
    if (state.uiState.showLostDialog) {
        GameDialogs().AcceptDialog(
            bodyText = "has perdido"
        ) {
            actions.resetGame()
        }
    }
    Body(state, actions)
}

@Composable
private fun Body(state: GameScreenState, actions: GameScreenActions) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Header()
        Box(
            Modifier
                .weight(5f)
                .fillMaxWidth()
        ) {
            ColorsView(state.listColorRows)
        }
        Box(Modifier.weight(1f)) {
            CurrentGameColorItemRow(state, actions)
        }
        Box(Modifier.weight(1f)) {
            ConfirmButton { actions.onValidateRow() }
        }

    }
}

@Composable
private fun Header() {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f),
        contentAlignment = Alignment.Center
    ) {
        Text("Game Header")
    }
}

@Composable
private fun ColorsView(listColorRows: List<ColorRow>) {
    LazyColumn {
        itemsIndexed(listColorRows) { index, row ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(BoxSize.largeBox),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier
                        .height(30.dp)
                        .fillMaxWidth(0.05f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "${index + 1}")
                }
                for (spot in row.spotList) {
                    SpotColorsRow(spot)
                }
                Box(
                    Modifier
                        .fillMaxWidth(0.05f),
                    contentAlignment = Alignment.Center
                ) {
                    VerticalDivider()
                }
                for (spot in row.validationList) {
                    SpotColorsRow(spot)
                }
            }
        }
    }
}

@Composable
private fun CurrentGameColorItemRow(state: GameScreenState, actions: GameScreenActions) {
    Box(
        Modifier
            .fillMaxHeight()
    ) {
        ColorSelector(state.currentColors, state.spotSelected, actions)
        LazyRow(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            itemsIndexed(state.currentRow.spotList) { index, spot ->
                SpotColorsRow(spot, state.spotSelected, index) { actions.onSpotSelected(index) }
            }
        }
    }
}

@Composable
private fun SpotColorsRow(
    spot: SpotColor,
    currentIndex: Int? = null,
    indexSelected: Int? = null,
    updateSpotSelected: ((Int?) -> Unit)? = null
) {
    SpacerHXxSmall()
    Box {
        if (indexSelected != null && indexSelected == currentIndex) {
            Box(Modifier.size(30.dp)) {
                OverflowBox {
                    Icon(
                        imageVector = Icons.Outlined.ArrowDropDown,
                        contentDescription = "selected color arrow",
                        Modifier
                            .size(50.dp)
                            .offset(0.dp, -30.dp)
                            .zIndex(-1f),
                        tint = outlineDark
                    )
                }
            }
        }
        Box(
            Modifier
                .clip(shape = RoundedCornerShape(50.dp))
                .background(spot.selectedColor.color)
                .size(30.dp)
                .border(BorderStroke(BorderSize.borderS, outlineDark), shape = RoundedCornerShape(50.dp))
                .clickable(
                    onClick = {
                        updateSpotSelected?.invoke(indexSelected)
                    }
                )
        )
    }
    SpacerHXxSmall()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ColorSelector(colorsList: List<PuzzleColors>, spotSelected: Int?, actions: GameScreenActions) {
    if (spotSelected == null) return
    Popup(
        properties = PopupProperties(focusable = true),
        offset = IntOffset(0, -45),
        alignment = Alignment.TopCenter,
        onDismissRequest = { actions.onSpotSelected(spotSelected) }) {
        FlowRow(
            Modifier
                .wrapContentHeight()
                .clip(RoundedCornerShape(5.dp))
                .background(secondaryDark)
                .border(BorderStroke(1.dp, outlineDark), shape = RoundedCornerShape(5.dp)),
            maxItemsInEachRow = 5,
            horizontalArrangement = Arrangement.Center
        ) {
            for (color in colorsList) {
                Box(
                    Modifier
                        .clickable(
                            onClick = { actions.onColorSelected(color) }
                        )
                        .size(BoxSize.largeBox)
                        .padding(Spacing.xSmall)
                        .clip(RoundedCornerShape(5.dp))
                        .background(color.color)
                )
            }
        }
    }
}

@Composable
private fun ConfirmButton(onValidateRow: () -> Unit) {
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        CMElevatedButton(Modifier, stringResource(R.string.play)) { onValidateRow() }
    }
}


