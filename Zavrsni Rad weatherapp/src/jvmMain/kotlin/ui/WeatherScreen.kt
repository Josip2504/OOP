package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import controller.LoginController
import controller.NavController
import controller.WeatherController
import db.DatabaseConnection
import kotlinx.coroutines.launch
import util.AuthenticationService
import util.Lce

@Composable
@Preview
fun WeatherScreen(
    navController: NavController,
    authenticationService: AuthenticationService,
    weatherController: WeatherController,
    loginController: LoginController
) {

    val db = DatabaseConnection()
    var queriedCity by remember { mutableStateOf(weatherController.getUserById(authenticationService.getAuthenticatedUserId())?.location?: "") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(authenticationService.getAuthenticatedUserId()) {
        if(authenticationService.getAuthenticatedUserId() > 0){
            weatherController.setState(Lce.Loading)
            weatherController.setState(weatherController.weatherForCity(queriedCity))
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {
                    loginController.logout()
                    navController.navigateToLogin()
                },
                modifier = Modifier.rotate(-90f)
            ){
                Icon(Icons.Default.ExitToApp, "logout")
            }
            TextField(
                shape = CircleShape,
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
                shape = CircleShape,
                border = BorderStroke(2.dp, Color.Transparent),
                onClick = {
                    weatherController.setState(Lce.Loading)
                    db.addHistory(queriedCity)
                    scope.launch {
                        weatherController.setState(weatherController.weatherForCity(queriedCity))
                    }
                }
            ){
                Icon(Icons.Outlined.Search, "Search")
            }
        }
        when(val state = weatherController.weatherState.value){
            is Lce.Content -> ContentUI(state.data)
            is Lce.Error -> ErrorUI()
            Lce.Loading -> LoadingUI()
            else -> {}
        }
    }
}