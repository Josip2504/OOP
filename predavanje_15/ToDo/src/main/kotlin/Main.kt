import model.Task
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.filter
import org.ktorm.entity.first
import org.ktorm.entity.removeIf
import schema.tasks
import schema.users
import java.util.Scanner

fun main(args: Array<String>) {
    val db = DatabaseConnection().connection

    val scanner = Scanner(System.`in`)

    println("Enter name:")
    val userName = scanner.next()

    println("Enter password:")
    val password = scanner.next()

    val user = db.users.first {
        it.name eq userName
    }
    if(user.name != userName){
        println("Invalid credentials")
        return
    }
    if(user.password == password){
        println("Welcome")

        while(true) {
            println("Current tasks: ")
            val currentTasks = db.tasks.filter {
                it.userId eq user.id
            }
            for (task in currentTasks) {
                println("${task.id}: ${task.name}")
            }

            println("What do you want to do next?")
            println("1. Create task")
            println("2. Delete task")
            println("3. Sign out")
            var userSelection = scanner.nextInt()
            scanner.nextLine()

            when (userSelection){
                1 -> {
                    println("Enter task:")
                    val newTask = scanner.nextLine()
                    db.tasks.add(
                        Task {
                            name = newTask
                            this.user = user
                        }
                    )
                    println("Task $newTask added successfully!")
                }
                2 -> {
                    println("Enter task you want to delete: ")
                    val deleteTask = scanner.nextInt()
                    db.tasks.removeIf { it.id eq  deleteTask }
                    println("Successfully deleted")

                }
                3 -> {
                    println("You signed out")
                    break
                }
            }


        }
    }else{
        println("Invalid credentials")
    }
}