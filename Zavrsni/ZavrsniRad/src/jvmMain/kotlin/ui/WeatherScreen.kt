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
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun WeatherScreen() {

    var queriedCity by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
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
                onClick = {/* not jet */}
            ){
                Icon(Icons.Outlined.Search, "Search")
            }
        }
    }
}