package schema

import model.Owner
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

val Database.owners get() = this.sequenceOf(Owners)
object Owners: Table<Owner>("owners") {
    val id = int("id").primaryKey().bindTo { it.id }
    var name = varchar("name").bindTo { it.name }
}