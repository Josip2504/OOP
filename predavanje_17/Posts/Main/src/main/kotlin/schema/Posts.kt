package schema

import model.Post
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

val Database.posts get() = this.sequenceOf(Posts)

object Posts: Table<Post>("posts") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val userId = int("userId").references(Users) {it.user}
}