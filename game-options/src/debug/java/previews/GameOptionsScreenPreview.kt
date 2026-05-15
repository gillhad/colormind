package previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gillhad.designsystem.theme.backgroundColorPreview
import com.gillhad.gameoptions.presentation.GameOptionsView

@Preview(
    showBackground = true,
    backgroundColor = backgroundColorPreview
)
@Composable
fun GameOptionsScreenPreview() {
    GameOptionsView(Modifier)
}