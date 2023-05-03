import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
@Preview
fun App() {
//    var textFieldStateUsername by remember {
//        mutableStateOf(randomText())
//    }
//
//    var randomColor by remember {
//        mutableStateOf(randomColor())
//    }



//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Row(
//            modifier = Modifier.padding(24.dp).background(Color.DarkGray).fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Text("Hello world!", fontSize = 24.sp, modifier = Modifier.background(Color.Cyan))
//            Text("My name is Matej!",fontSize = 16.sp, modifier = Modifier.background(Color.Magenta))
//            Text("Nice to see you!", fontSize = 32.sp, modifier = Modifier.background(Color.Red))
//
//
//        }
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center
//        ) {
//            TextField(
//                textFieldStateUsername,
//                label = {
//                    Text("Placeholder")
//                },
//                onValueChange = {
//                    textFieldStateUsername = it
//                }
//            )
//        }
//        Button(
//            modifier = Modifier.background(randomColor),
//            onClick = {
//                println(textFieldStateUsername)
//            }
//        ) {
//            Text("Print")
//        }
//    }

//    LazyColumn {
//        item {
//            Text(text = "Header")
//        }
//
//        items(3) {index ->
//            Text(text = "First list of items: item index $index")
//        }
//
//        items(2) {index ->
//            Text(text = "Second list of items: item index $index")
//        }
//
//        item {
//            Text(text = "Footer")
//        }
//    }

    val countryList = listOf<Countries>(
        Countries(name = "Croatia", image = "https://cdn.britannica.com/06/6206-004-14730C28/Flag-Croatia.jpg"),
        Countries(name = "Serbia", image = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Flag_of_Serbia.svg/800px-Flag_of_Serbia.svg.png",)
    )//, "Bosnia", "Hungary", "Slovenia", "Italy")

    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.Gray).padding(10.dp)) {
        items(countryList){
            RowList(it)
        }
//        items(countryList) { country ->
//            Text(text = country, modifier = Modifier.padding(10.dp) ,style = TextStyle(fontSize = 20.sp, color = Color.White))
//        }
    }

}

data class Countries(val name: String, val image: String)

@Composable
fun RowList(country: Countries) {
    val image =  ImageLoaderFromNetwork().loadNetworkImage(country.image)

    Row {
        Image(image, country.name)
        Text(country.name)
    }
}

fun randomColor(): Color{
    val list = listOf(Color.Black, Color.Red, Color.Green,Color.Cyan, Color.Magenta, Color.Blue)

    return list[(list.indices).random()]
}

fun randomText(): String{
    val list = listOf("Hello", "Bye", "Whats up", "dasida", "sdasda", "sada", "sadsd")

    return list[(list.indices).random()]
}
