import schema.users
import java.util.Scanner

class Read() {

    fun start(){

        val scanner = Scanner(System.`in`)
        val db = DatabaseConnection().connection

        println("Enter a name of user you wanna see:")
        var userToSee = scanner.next()
        for (user in db.users){
            if (user.name == userToSee){
                println("User name: ${user.name} and his ID: ${user.id}")
                break
            }else{
                println("$userToSee doesn't exist")
                break
            }
        }
    }
}