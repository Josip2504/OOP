package schema

import model.Animal
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

val Database.animals get() = this.sequenceOf(Animals)
object Animals: Table<Animal>("animals") {
    val id = int("id").primaryKey().bindTo { it.id }
    var name = varchar("name").bindTo { it.name }
    var ownerId = int("owner_id").references(Owners) { it.owner }
}