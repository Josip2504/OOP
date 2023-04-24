
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Owners: Table<Nothing>("owners") {
    val id = int("id").primaryKey()
    val name = varchar("name")
}