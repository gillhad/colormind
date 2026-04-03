package com.gillhad.game

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gillhad.shared.R.string.accept
import com.gillhad.shared.R.string.cancel
import com.gillhad.shared.R.string.dialog_content1
import com.gillhad.shared.R.string.dialog_title

class GameDialogs {

    @Composable
    fun BaseDialog(
        titleText: String? = null,
        bodyText: String? = null,
        acceptText: String? = null,
        dismissText: String? = null,
        onAccept: (() -> Unit)? = null,
        onDismiss: (() -> Unit)? = null
    ) {
        AlertDialog(
            onDismissRequest = { onDismiss?.invoke() },
            title = { Text(titleText ?: stringResource(dialog_title)) },
            text = { Text(bodyText ?: stringResource(dialog_content1)) },
            confirmButton = {
                TextButton(onClick = { onAccept?.invoke() }) {
                    Text(acceptText ?: stringResource(accept))
                }
            },
            dismissButton = {
                onDismiss?.let {
                    TextButton(onClick = { onDismiss.invoke() }) {
                        Text(dismissText ?: stringResource(cancel))
                    }
                }
            }
        )
    }

    @Composable
    fun OptionalDialog(
        titleText: String? = null,
        bodyText: String? = null,
        acceptText: String? = null,
        cancelText: String? = null,
        onAccept: () -> Unit,
        onDismiss: () -> Unit
    ) {
        BaseDialog(
            titleText = titleText,
            bodyText = bodyText,
            acceptText = acceptText,
            dismissText = cancelText,
            onAccept = onAccept,
            onDismiss = onDismiss
        )
    }

    @Composable
    fun AcceptDialog(
        titleText: String? = null,
        bodyText: String? = null,
        acceptText: String? = null,
        onAccept: (() -> Unit)? = null
    ) {
        BaseDialog(
            titleText = titleText,
            bodyText = bodyText,
            acceptText = acceptText,
            onAccept = onAccept
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OptionalDialogPreview() {
    GameDialogs().OptionalDialog(
        onAccept = {},
        onDismiss = {}
    )
}

@Preview(showBackground = true)
@Composable
fun AcceptDialogPreview() {
    GameDialogs().AcceptDialog(onAccept = {})
}