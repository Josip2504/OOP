import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Animals: Table<Nothing>("animals") {
    val id = int("id").primaryKey()
    val name = varchar("name")
    val ownerId = int("owner_id")
}