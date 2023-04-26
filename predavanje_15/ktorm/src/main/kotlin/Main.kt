import org.ktorm.dsl.gt
import org.ktorm.entity.removeIf
import schema.animals
import schema.owners

fun main(args: Array<String>) {
    val db = DatabaseConnection().connection

//    db.owners.add(
//        Owner {
//            name = "Đuro"
//        }
//    )

//    db.animals.add(
//        Animal {
//            name = "garfield"
//            ownerId = 3
//        }
//    )



    for(owner in db.owners){
        println("Owner ${owner.id}: ${owner.name} ")
    }

    for(animal in db.animals) {
        if(animal.id == 4) {
            // Update
//            animal.name = "Garfield"
//            animal.flushChanges()
        }
    }

    // Delete from animals where owner_id > 4;
    db.animals.removeIf {
        it.id gt 4
    }

    for(animal in db.animals) {
        println("Owner of ${animal.name} is ${animal.owner.name}")
    }






}