open class Vehicle(
    val proizvodac: String,
    val model: String,
    val godina: Int,
    private var engine: Boolean = false
)
{
    
    open fun startEngine(){
        if (!engine){
            engine = true
            println("Engine is on")
        }else{
            println("Engine is already on!")
        }
    }

    open fun stopEngine(){
        if (engine){
            engine = false
            println("Engine is off")
        }else{
            println("Engine is already off!")
        }
    }
}