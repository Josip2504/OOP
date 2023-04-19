class Cat(name: String): Animal(name) {
    override fun makeSound() {
        println("Cat named $name says meow!")
    }

    override fun walk() {
        println("Cat named $name is walking!")
    }
}