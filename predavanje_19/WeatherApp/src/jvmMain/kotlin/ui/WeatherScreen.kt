package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import model.WeatherResults
import repository.Repository
import util.Lce

@Composable
@Preview
fun WeatherScreen(repository: Repository) {

    var queriedCity by remember { mutableStateOf("") }
    var weatherState by remember { mutableStateOf<Lce<WeatherResults>?>(null) }
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                modifier = Modifier.padding(16.dp).weight(1f),
                value = queriedCity,
                singleLine = true,
                onValueChange = { queriedCity = it },
                placeholder = {
                    Text("Any city, really...")
                },
                label = { Text("Search for city") },
                leadingIcon =  { Icon(Icons.Filled.LocationOn, "Location")  }
            )
            Button(
                onClick = {
                    weatherState = Lce.Loading
                    scope.launch {
                        weatherState = repository.weatherForCity(queriedCity)
                    }
                }
            ){
                Icon(Icons.Outlined.Search, "Search")
            }
        }
        when(val state = weatherState){
            is Lce.Content -> ContentUI(state.data)
            is Lce.Error -> ErrorUI()
            Lce.Loading -> LoadingUI()
            else -> {}
        }
    }
}