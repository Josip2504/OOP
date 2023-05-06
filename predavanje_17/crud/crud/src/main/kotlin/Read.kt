import model.User
import org.ktorm.dsl.eq
import org.ktorm.entity.filter
import org.ktorm.entity.forEach
import org.ktorm.entity.isNotEmpty
import schema.Users
import schema.users
import java.util.Scanner

class Read(val dbConnection: DatabaseConnection) {

    fun start(){

        val scanner = Scanner(System.`in`)
        val db = dbConnection.connection

        println("Enter a name of user you wanna see:")
        val userSearch = scanner.next()
        val userToSee = db.users.filter {
            it.name eq userSearch
        }
        if (userToSee.isNotEmpty()) {
            userToSee.forEach {user ->
                println("User: ${user.name} with ID: ${user.id}")
            }
        }else{
            println("No user found with name: $userToSee")
        }
    }
}