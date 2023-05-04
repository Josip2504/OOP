import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import repository.Repository
import ui.WeatherScreen

private const val API_KEY = "10b98aeeebfb4094a41172245230205"

fun main() = application {
    Window(
        state = rememberWindowState(size = DpSize(800.dp, 1000.dp)),
        onCloseRequest = ::exitApplication,
        title = "Weather app"
    ) {
        val repository: Repository = Repository(apiKey = API_KEY)

        MaterialTheme {
            WeatherScreen(repository)
        }
    }
}
