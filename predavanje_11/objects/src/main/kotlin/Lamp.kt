// Sekundarni konstruktor
class Lamp constructor(
    private var initialState: Boolean,
    private var usersLightColor: String,
    private var userLampName: String
) {


    // Primarni konstruktor
    private var isOn: Boolean
    public var lightColor: String
    private var name: String
//    protected var lampColor = "Yellow"
//    internal var lampColor = "Yellow"

    // Inicijalizacijski konstruktor
    init {
        if(initialState) {
            println("Ugasi lampu prije!")
        }
        isOn = initialState
        lightColor = usersLightColor.replaceFirstChar { char -> char.uppercase() }
        name = userLampName
    }

    fun turnOff() {
        isOn = false
    }

    fun turnOn() {
        isOn = true
        println("Lamp turned on!")
    }

    fun lightStatus() {
        if(isOn) {
            println("Lamp \"$name\" is on and glowing $lightColor")
        }else{
            println("Lamp \"$name\" is off and usually glows $lightColor")
        }
    }

    fun changeName(newName: String) {
        name = newName
    }
}