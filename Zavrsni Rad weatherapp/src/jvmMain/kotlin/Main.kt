import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import controller.LoginController
import controller.NavController
import controller.WeatherController
import db.DatabaseConnection
import repository.Repository
import ui.LoginScreen
import ui.RegisterScreen
import ui.WeatherScreen
import util.AuthenticationService


fun main() = application {

    val db = DatabaseConnection()
    val repository = Repository(db)
    val authService = AuthenticationService(db)
    val navController = NavController()
    val loginController = LoginController(authService, navController, repository)
    val weatherController = WeatherController(repository, authService)

    Window(
        state = rememberWindowState(size = DpSize(800.dp, 1000.dp)),
        onCloseRequest = ::exitApplication,
        title = "Weather app"
    ) {
        val scaffoldState = rememberScaffoldState()

        MaterialTheme() {


//            TEST ZA GET HISTORY
//            db.getHistory()


            when(navController.currentScreen.value){
                NavController.Screen.LOGIN -> {
                    Scaffold(
                        Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier.fillMaxSize().padding(24.dp)
                        ) {
                            Text("Welcome to Weather App!", style = MaterialTheme.typography.h4)
                        }
                        LoginScreen(navController, loginController)
                    }
                }
                NavController.Screen.REGISTER -> {
                    Scaffold(
                        Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier.fillMaxSize().padding(24.dp)
                        ) {
                            Text("Welcome to Weather App!", style = MaterialTheme.typography.h4)
                        }
                        RegisterScreen(navController, loginController)
                    }
                }
                NavController.Screen.HOME -> WeatherScreen(navController, authService, weatherController, loginController)
            }
        }
    }
}
