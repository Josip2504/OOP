fun main() {
    val list: MutableList<FlyingAnimal> = mutableListOf()
}

interface Animal {
    fun eat()
    fun sleep()
}

interface FlyingAnimal {
    fun fly()
}

class Cat: Animal {
    override fun eat() {
        println("Cat is eating")
    }

    override fun sleep() {
        println("Cat is sleeping")
    }

}

class Bird: Animal, FlyingAnimal {
    override fun eat() {
        println("Bird is eating")
    }

    override fun sleep() {
        println("Bird is sleeping")
    }

    override fun fly() {
        println("Bird is flying")
    }

}