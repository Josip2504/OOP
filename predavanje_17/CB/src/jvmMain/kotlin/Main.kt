import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.layout.Row
import androidx.compose.material.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter your name") }
        )

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter your password") }
        )

        Button(
            modifier = Modifier.background(Color.Gray),
            onClick = {
                println("logged in")
                Modifier.background(color()).also {}
            }
        ) { Text("Log in") }
    }
}

fun color(): Color{
    val list = listOf(Color.Black, Color.Red, Color.Green)
    return list[(list.indices).random()]
}



