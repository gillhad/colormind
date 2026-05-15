package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gillhad.designsystem.composable.ValueAdjusterButtons

@Preview(showBackground = true)
@Composable
fun ValueAdjusterButtonsPreview() {
    ValueAdjusterButtons(3,3..5,{})
}