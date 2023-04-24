fun main() {



}

interface Vehicle {
    fun moveForward()
    fun moveBack()
}

abstract class VehicleWithEngine: Vehicle {
    protected var isEngineWorking = false
    abstract fun startEngine()
    abstract fun stopEngine()
}

class Car: VehicleWithEngine() {
    override fun startEngine() {
        println("Engine starts")
        isEngineWorking = true
    }

    override fun stopEngine() {
        println("Engine Stops")
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
        println("Moving back")
    }
}