import org.ktorm.dsl.eq
import org.ktorm.entity.removeIf
import schema.Users
import schema.users
import java.util.Scanner

class Delete {

    fun start(){

        val db = DatabaseConnection().connection
        val scanner = Scanner(System.`in`)

        println("Enter a name of a user you want to delete: ")
        val userToDelete = scanner.next()
        for (users in db.users) {
                db.users.removeIf { Users.name eq userToDelete }
        }

    }

}