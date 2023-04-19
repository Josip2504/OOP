fun main() {
    val zoo = Zoo()
    val dog = Dog("Zuco")
    val cat = Cat("Garfield")
    val elephant = Elephant("Dumbo")

//    val zooKeeper = ZooKeeper()
//    dog.makeSound()
//    cat.makeSound()

    zoo.addAnimal(dog)
    zoo.addAnimal(cat)
    zoo.addAnimal(elephant)

//    dog.walk()
//    dog.walk()
//    dog.eats()

    dog.tailWig()

    elephant.walk()
    elephant.eats()



//    cat.walk()
//    elephant.walk()
//    zoo.addAnimal(zooKeeper) // Ne prolazi jer ne nasljeduje Animals klasu

    zoo.makeAllSounds()

}