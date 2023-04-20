fun main() {

}

interface Vehicle{
    fun moveForward()
    fun moveBack()
}

abstract class VehicleWhitEngine: Vehicle{
    protected var isEngineWorking = false
    abstract fun startEngine()
    abstract fun stopEngine()
}

class Car: VehicleWhitEngine(){
    override fun startEngine() {
        println("Engine starts")
        isEngineWorking = true
    }

    override fun stopEngine() {
        println("Engine stops")
        isEngineWorking = false
    }

    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving back")
    }
}

class Bicycle: Vehicle {
    override fun moveForward() {
        println("Moving forward")
    }

    override fun moveBack() {
        println("Moving Back")
    }
}