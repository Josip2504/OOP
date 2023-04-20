fun main() {
    val user = User(1, "Josip", "1234")
    val authService = AuthenticationService()

    authService.signIn(user.name, user.passowrd)
    authService.signOut(user.id)

}

data class User(
    var id: Long,
    var name: String,
    var passowrd: String
)

class AuthenticationService(){
    fun signIn(name: String, passowrd: String){
        LoggingService().createLog("User signed in")
    }

    fun signOut(id: Long){
        LoggingService().createLog("User signed out")
    }
}

class LoggingService(){
    fun createLog(message: String){
        println(message)
    }
}