package schema

import model.Odjel
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

val Database.odjel get() = this.sequenceOf(Odjeli)

object Odjeli: Table<Odjel>("Odjeli") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val userId = int("user_id").references(Users) { it.user }
}