class Elephant(name: String): Animal(name) {
    override fun makeSound() {
        println("Elephant named $name says fruuuu!")
    }

    override fun walk() {
        energy -= 50
    }

}