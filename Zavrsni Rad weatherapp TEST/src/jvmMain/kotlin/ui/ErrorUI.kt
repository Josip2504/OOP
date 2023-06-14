package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ErrorUI() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Something went wrong, maybe that city doesn't exist or check again in few minutes... ¯\\_(ツ)_/¯",
            modifier = Modifier.fillMaxSize().padding(72.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.h6
        )
    }
}