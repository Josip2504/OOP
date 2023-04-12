val a = 2 // Globalna varijabla

fun main() {

    val b = 2 // Funkcijska varijabla
    val bedroomLamp: Lamp = Lamp(true, "Red", "Bedroom Lamp")
    val livingRoomLamp: Lamp = Lamp(false, "yellow", "Living room Lamp")

//    bedroomLamp.turnOff()
//    bedroomLamp.lightStatus()
//    bedroomLamp.turnOn()
//    bedroomLamp.lightStatus()

//    bedroomLamp.isOn = true // NE zelimo pristupiti privatnoj varijabli
//    bedroomLamp.lightColor = "Yellow"


    bedroomLamp.turnOn()
    bedroomLamp.lightStatus()
    livingRoomLamp.lightStatus()

    bedroomLamp.changeName("New Bedroom Lamp")

    livingRoomLamp.lightStatus()
    bedroomLamp.lightStatus()
}

//fun addTwoNumbers() {
//    val c = 0 // Funkcijska varijabla
//    2+a  // poziv globalne varijable
////    2+b // ne mozemo pristupiti
//    2+c // Poziv funkcijske varijable
//}