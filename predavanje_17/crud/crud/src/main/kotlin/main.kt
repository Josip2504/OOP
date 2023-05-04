import org.ktorm.dsl.eq
import schema.users
import java.util.Scanner

fun main() {
    //val db = DatabaseConnection().connection
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Hello. What do you want to do?")
        println("1. Create")
        println("2. Read")
        println("3. Update")
        println("4. Delete")
        println("5. Exit app")
        val choice = scanner.nextInt()

        when (choice){
            1->{
                Create().start()
            }
            2->{
                Read().start()
            }
            3->{}
            4->{}
            5->{
                println("Thanks for using app, bye!")
                break
            }
        }
    }
}