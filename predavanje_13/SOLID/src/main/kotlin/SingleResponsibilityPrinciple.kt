fun main() {
    val user = User(1, "Matej", "12345")
    val authService = AuthenticationService()

    authService.signIn(user.name, user.password)

    authService.signOut(user.id)
}

data class User(
    var id: Long,
    var name: String,
    var password: String
)

class AuthenticationService() {
    fun signIn(name: String, password: String){
        // Something that will sign us in
        LoggingService().createLog("User signed in")
    }

    fun signOut(id: Long){
        // Something that will sign us out
        LoggingService().createLog("User signed out")
    }
}

class LoggingService(){
    fun createLog(message: String){
        println(message)
    }
}

