package ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import controller.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import controller.LoginController
import util.Lce

@Composable
fun LoginScreen(navController: NavController, loginController: LoginController) {

    var textFieldUsernameState by remember { mutableStateOf("") }
    var textFieldPasswordState by remember { mutableStateOf("") }


    Box(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Welcome to the Weather App",
                modifier = Modifier.padding(50.dp, top = 110.dp),
                textAlign = TextAlign.Center,
                fontSize = 40.sp
            )
        }

        when(val state = loginController.uiState.value){
            is Lce.Content -> TODO()
            is Lce.Error -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize().padding(24.dp)
                ) {
                    Text(text = state.error.message?: "Unknown error!")
                    Button(
                        onClick ={
                            loginController.setState(null)
                        }
                    ){
                        Text("Back")
                    }
                }
            }
            Lce.Loading -> LoadingUI()
            null -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize().padding(24.dp)
                ) {
                    TextField(
                        shape = RoundedCornerShape(10.dp),
                        value = textFieldUsernameState,
                        onValueChange = {
                            textFieldUsernameState = it
                        },
                        label = {
                            Text("Enter your username")
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    TextField(
                        shape = RoundedCornerShape(10.dp),
                        value = textFieldPasswordState,
                        onValueChange = {
                            textFieldPasswordState = it
                        },
                        label = {
                            Text("Enter your password")
                        },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.size(16.dp))


//              CHECKBOX NIJE DOVRSENO
//                    Row {
//                        Checkbox(
//                            checked = true,
//                            onCheckedChange = null,
//                            modifier = Modifier.padding(all = 10.dp)
//                        )
//                        Text("Remember me", modifier = Modifier.padding(top = 14.dp))
//                    }


                    Row {
                        Button(
                            shape = CircleShape,
                            onClick = {
                                loginController.onLogin(textFieldUsernameState, textFieldPasswordState)
                            }
                        ){
                            Text("Login")
                        }
                        ClickableText(
                            modifier = Modifier.align(Alignment.Bottom).padding(16.dp),
                            text = AnnotatedString("or register"),
                            onClick = {
                                navController.navigateToRegister()
                            }
                        )
                    }
                }
            }
        }
    }

}
