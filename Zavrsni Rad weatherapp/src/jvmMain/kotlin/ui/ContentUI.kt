package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dao.Historys
import db.DatabaseConnection
import model.History
import model.WeatherResults
import util.ImageDownloader

@Composable
@Preview
fun ContentUI(data: WeatherResults) {
    val db = DatabaseConnection()
    var imageState by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(data.currentWeather.iconUrl){
        imageState = ImageDownloader().downloadImage(data.currentWeather.iconUrl)
    }

    Text(
        modifier = Modifier.padding(end = 10.dp),
        text = "Current Weather",
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.h5
    )

    Card(
        border = BorderStroke(1.dp, Color.Gray),
        elevation = 50.dp,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 72.dp,)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = data.currentWeather.condition,
                style = MaterialTheme.typography.h5
            )
        }

        Row(
            modifier = Modifier.padding(10.dp, top = 60.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Column(

            ) {
                imageState?.let {bitmap ->
                    Image(
                        bitmap = bitmap,
                        contentDescription = null,
                        modifier = Modifier.defaultMinSize(150.dp, 150.dp)
                            .padding(8.dp, bottom = 40.dp)
                    )
                }
            }
            Column(

            ) {
                Text(
                    text = "Temperature in °C: ${data.currentWeather.temperature}",
                    modifier = Modifier.padding(100.dp, top = 35.dp),
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = "Feels Like: ${data.currentWeather.feelsLike} °C",
                    modifier = Modifier.padding(start = 100.dp, top = 10.dp),
                    style = MaterialTheme.typography.h6
                )

            }
        }
    }

    Divider(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(16.dp)
    )

    Text(
        text = "Forecast",
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.h5
    )

    LazyRow {
        items(data.forecast) {weatherCard ->
            ForecastUi(weatherCard)
        }
    }

    Divider(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(16.dp)
    )

    Text(
        text = "History",
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.h5
    )



}