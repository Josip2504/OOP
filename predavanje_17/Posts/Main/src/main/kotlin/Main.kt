import java.util.Scanner

fun main() {

    val db = DatabaseConnection()
    val scanner = Scanner(System.`in`)

    while (true){
        println("Welcome to Posts app! What do you want to do?")
        println("1. Login")
        println("2. Register")
        println("3. Exit")

        val choice = scanner.nextInt()

        when (choice) {
            1->{}
            2->{
                Register(db).start()
            }
            3->{
                println("Thanks for using the app bye!")
                break
            }
        }
    }
}