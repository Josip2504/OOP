class Zoo(private val animals: MutableList<Animal> = mutableListOf()){
    fun makeAllSounds() {
        for (animal in animals) {
            animal.makeSound()
        }
    }

    fun addAnimal(animal: Animal){
        animals.add(animal)
    }
}