class Dog(name: String) : Animal(name){
    override fun makeSound() {
//        super.makeSound()
        println("Dog named $name says Woof!")
    }

    override fun walk() {
        super.walk()
        println("Dog named $name is walking! Current energy: $energy")
    }

    fun tailWig() {
        println("Dog wigs his tail at us!")
    }
}