import org.ktorm.dsl.insertAndGenerateKey
import schema.Users
import java.util.*

class Create {

    fun start(){

        val scanner = Scanner(System.`in`)
        val db = DatabaseConnection().connection

        println("Enter a name of User you want to add: ")
        val userToAdd = scanner.next()

        val newUser = db.insertAndGenerateKey(Users){
            set(it.name, userToAdd)
        }
        println("User $userToAdd successfully added!")
    }
}