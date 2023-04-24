fun main(args: Array<String>) {

    val db = DatabaseConnection()
    db.connect()

//    if (db.connection == null) {
//        println("Connection not successful")
//    }else {
//        println("Connected successfully")
//    }

    val userInput = "u"

    val animals: MutableList<Animal> = mutableListOf()
    val owners: MutableList<Owner> = mutableListOf()

    val queryAnimals = "Select * from animals where name like \"%\"?\"%\""
    val queryOwners = "Select * from owners"

    val resultSetAnimals = db.executeStatement(queryAnimals, userInput)
    val resultSetOwners = db.executeStatement(queryOwners)

    while (resultSetOwners?.next() == true) {
        val id = resultSetOwners.getInt("id")
        val name = resultSetOwners.getString("name")
        val owner = Owner(id, name)
        owners.add(owner)
    }

    while (resultSetAnimals?.next() == true) {
        val id = resultSetAnimals.getInt("id")
        val name = resultSetAnimals.getString("name")
        val ownerId = resultSetAnimals.getInt("owner_id")

        val owner = owners.first {
            it.id == ownerId
        }

        val animal = Animal(id, name, owner)
        animals.add(animal)
    }

    animals.forEach {
        println("${it.name} with id ${it.id} belongs to ${it.owner.name}")
    }

}
