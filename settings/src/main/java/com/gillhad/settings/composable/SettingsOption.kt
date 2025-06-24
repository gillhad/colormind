package com.gillhad.settings.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gillhad.designsystem.theme.BoxSize
import com.gillhad.designsystem.theme.Spacing
import com.gillhad.shared.R

@Composable
fun SettingsOption(title: Int,action: ()->Unit){
    Box(Modifier.padding(vertical = Spacing.large)) {
        Box(
            Modifier
                .shadow(
                    4.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .sizeIn(3.dp)
                .fillMaxWidth()
                .height(BoxSize.largeBox)
                .background(Color.White)
                .clip(shape = RoundedCornerShape(20.dp))
                .clickable(onClick = { action() }),
            contentAlignment = Alignment.Center
        ) {
            Text(stringResource(title))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsOptionPreview(){
    Box(Modifier.padding(5.dp)) {
        SettingsOption(R.string.settings){ println("")}
    }
}