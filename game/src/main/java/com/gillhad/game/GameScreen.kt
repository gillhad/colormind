package com.gillhad.game

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.gillhad.designsystem.composable.spacers.SpacerHXxSmall
import com.gillhad.designsystem.theme.BorderSize
import com.gillhad.designsystem.theme.BoxSize
import com.gillhad.designsystem.theme.Spacing
import com.gillhad.designsystem.theme.outlineDark
import com.gillhad.designsystem.theme.secondaryDark
import com.gillhad.designsystem.theme.spotColorBlue
import com.gillhad.designsystem.theme.spotColorClose
import com.gillhad.designsystem.theme.spotColorGreen
import com.gillhad.designsystem.theme.spotColorPurple
import com.gillhad.designsystem.theme.spotColorRed
import com.gillhad.designsystem.theme.spotColorValid
import com.gillhad.designsystem.theme.spotColorYellow
import com.gillhad.shared.SizeConstants.colorGap
import com.gillhad.shared.composables.OverflowBox
import com.gillhad.shared.models.ColorRow
import com.gillhad.shared.models.SpotColor
import kotlin.math.ceil

data class GameScreenData(
    val amount: Int,
    val listColorRows: MutableList<ColorRow>,
    val currentRow: ColorRow,
    val currentPuzzle: ColorRow,
    val currentColors: List<Color>,
    var spotSelected: Int?
)

data class GameScreenState(
    val isLoading: () -> Unit,
    val showSelectColor: () -> Unit,
    val updateSelectedSpot: () -> Unit
)

@Composable
fun GameScreen(gameViewModel: GameViewModel) {
    val data = GameScreenData(
        amount = 4,
        listColorRows = mutableListOf(),
        currentRow = ColorRow(5, ""),
        currentPuzzle = ColorRow(5, ""),
        currentColors = listOf(
            spotColorRed, spotColorGreen, spotColorBlue, spotColorPurple, spotColorYellow,
            spotColorClose, spotColorValid
        ),
        spotSelected = 0
    )
    val state: GameScreenState = GameScreenState(
        isLoading = {},
        showSelectColor = { },
        updateSelectedSpot = { }
    )

    Scaffold { padding ->
        GameView(Modifier.padding(padding), data, state)
    }
}

@Composable
fun GameView(modifier: Modifier, data: GameScreenData, state: GameScreenState) {
    Body(data, state)
}

@Composable
private fun Body(data: GameScreenData, state: GameScreenState) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Header()
        Box(
            Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
        ) {
            ColorsView(data.listColorRows)
        }
        CurrentGameColorItemRow(data, state)
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
private fun ColorsView(listColorRows: MutableList<ColorRow>) {
    Column {
        for (row in listColorRows) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(BoxSize.largeBox),
                horizontalArrangement = Arrangement.Center
            ) {
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
                for (spot in row.validationList!!) {
                    SpotColorsRow(spot)
                }
            }
        }
    }
}

@Composable
private fun ColumnReviewedRows(listColorRow: MutableList<ColorRow>) {
}

@Composable
private fun CurrentGameColorItemRow(data: GameScreenData, state: GameScreenState) {
    Box(
        Modifier
            .fillMaxHeight()
    ) {
        ColorSelector(data.currentColors, data.spotSelected)
        LazyRow(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            itemsIndexed(data.currentRow.spotList) { index, spot ->
                SpotColorsRow(spot, data.spotSelected, index, state.updateSelectedSpot)
            }
        }
    }
}

@Composable
private fun SpotColorsRow(
    spot: SpotColor,
    currentIndex: Int? = null,
    indexSelected: Int? = null,
    updateSelectedSpot: () -> Unit? = { }
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
                .background(spot.selectedColor ?: spot.defaultColor)
                .size(30.dp)
                .border(BorderStroke(BorderSize.borderS, outlineDark), shape = RoundedCornerShape(50.dp))
                .clickable(
                    onClick = {
                        updateSelectedSpot()
                    }
                )
        )
    }
    SpacerHXxSmall()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ColorSelector(colorsList: List<Color>, spotSelected: Int?) {
    if (spotSelected == null) return
    val sizeProportion = ceil(colorsList.size.toDouble() / 5) * 20
    val selectorHeight = colorGap + sizeProportion
    OverflowBox {
        FlowRow(
            Modifier
                .offset(0.dp, -selectorHeight.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(5.dp))
                .background(secondaryDark)
                .border(BorderStroke(1.dp, outlineDark), shape = RoundedCornerShape(5.dp)),
            maxItemsInEachRow = 5
        ) {
            for (color in colorsList) {
                Box(
                    Modifier
                        .size(BoxSize.largeBox)
                        .padding(Spacing.xSmall)
                        .clip(RoundedCornerShape(5.dp))
                        .background(color)
                )
            }
        }
    }
}

