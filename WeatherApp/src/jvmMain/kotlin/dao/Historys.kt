package dao

import model.History
import model.User
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Historys: Table<History>("history") {
    val id = int("id").primaryKey().bindTo { it.id }
//    val user = varchar("user").references(Users){it.user}

}