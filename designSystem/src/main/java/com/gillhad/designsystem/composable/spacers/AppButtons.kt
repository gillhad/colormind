package com.gillhad.designsystem.composable.spacers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gillhad.designsystem.theme.ColorMindTheme
import com.gillhad.designsystem.theme.RoundedShapes

@Composable
fun CMElevatedButton(modifier: Modifier,text:String, action: () -> Unit) {
    ElevatedButton(
        onClick = action,
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(0.7f),
//        enabled = TODO(),
        shape = RoundedCornerShape(RoundedShapes.roundedMedium),
//        elevation = TODO(),
//        border = TODO(),
//        contentPadding = TODO(),
//        interactionSource = TODO()
    ) { Text(text) }
}

@Preview(showBackground = true)
@Composable
fun CMElevatedButtonPreview(){
    ColorMindTheme {
        Box(Modifier.fillMaxWidth()) {
            CMElevatedButton(
                Modifier,
                "POTATO",
                action = { println("action") }
            )
        }
    }
}