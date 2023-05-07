import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ui.WeatherScreen

fun main() = application {
    Window(
        state = rememberWindowState(size = DpSize(800.dp, 700.dp)),
        onCloseRequest = ::exitApplication,
        title = "Weather app"
    )
    {
        MaterialTheme {
            WeatherScreen()
        }
    }
}
