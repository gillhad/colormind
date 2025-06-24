package com.gillhad.designsystem.composable.spacers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gillhad.designsystem.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CMSlider(title: String, sliderState: SliderState, showValue : Boolean? = false, action: () -> Unit){
    Box(Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(horizontal = Spacing.xLarge)){
        Column {
            Text(title)
            Slider(value = sliderState.value, onValueChange = { action() } )
            Box(Modifier
                .fillMaxWidth()
                .padding(horizontal = Spacing.xxLarge), contentAlignment = Alignment.CenterEnd){
              if(showValue == true) Text(sliderState.value.toInt().toString()) else null
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CMSliderPreview(){
    var sliderState = SliderState(value = 50f)
    CMSlider("Title",sliderState, true, {})
}