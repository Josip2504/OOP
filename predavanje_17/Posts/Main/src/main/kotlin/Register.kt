import java.util.Scanner

class Register(private val db: DatabaseConnection) {

    fun start(): Boolean {
        val scanner = Scanner(System.`in`)

        println("Enter your name: ")
        val userName = scanner.next()

        println("Enter your password: ")
        val password = scanner.next()

        println("enter password again: ")
        val pass2 = scanner.next()

        if (!Util.checkPassword(password, pass2)){
            throw Exception("Password not same!")
        }

        return if (db.addNewUser(userName, password)){
            println("New user created!")
            true
        }else throw Exception("Could not register user")
    }
}