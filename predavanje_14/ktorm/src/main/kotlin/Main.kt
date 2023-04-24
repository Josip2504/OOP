import org.ktorm.dsl.from
import org.ktorm.dsl.select

fun main(args: Array<String>) {
    val db = DatabaseConnection().connection
    for(row in db.from(Animals).select()) {
        println("${row[Animals.name]} with id ${row[Animals.id]}")
    }
}