open class Animal(val name: String, var energy: Int = 100) {
    fun sleeps(){
        if(checkEnergy()){
            print("The animal won't sleep")
            return
        }
        println("The animal is sleeping")
        energy = 100
    }

    private fun checkEnergy(): Boolean{
        return energy > 91
    }

    open fun makeSound() {
        println("The Animal makes sound.")
    }

    open fun walk(){
        println("Animal walks and uses 20 energy points")
        energy -= 20
    }

    open fun eats() {
        if (checkEnergy()){
            println("Animal doesn't want to eat")
            return
        }
        println("Animal eats and restores energy by 10")
        energy += 10
        println("Current energy $energy")
    }
}