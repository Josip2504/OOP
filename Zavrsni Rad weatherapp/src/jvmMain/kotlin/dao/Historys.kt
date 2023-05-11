package dao

import model.History
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

val Database.historys get() = this.sequenceOf(Historys)

object Historys: Table<History>("historys") {
    val id = int("id").primaryKey().bindTo { it.id }
    val userId = int("user_id").references(Users){ it.userId }
    val location = varchar("location").bindTo { it.location }
}