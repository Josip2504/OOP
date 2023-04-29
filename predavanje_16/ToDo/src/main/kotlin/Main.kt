import java.util.Scanner

fun main() {
    val db = DatabaseConnection()

    val scanner = Scanner(System.`in`)

    while (true) {
        println("Welcome! What do you want to do?")
        println("1. Login")
        println("2. Register")
        println("3. Exit")
        val choice = scanner.nextInt()
        scanner.nextLine()

        when (choice) {
            1 -> {
                println("Enter name:")
                val userName = scanner.next()

                println("Enter password:")
                val password = scanner.next()

                val user = db.getUserByUsername(userName)
                if (user == null){
                    println("Invalid credentials")
                    continue
                }
                if(user.name != userName){
                    println("Invalid credentials")
                    continue
                }
                if(user.password == password){
                    println("Welcome")

                    while(true) {
                        println("Current tasks: ")
                        val currentTasks = db.getUserTasksList(user.id)
                        for (task in currentTasks) {
                            println("${task.id}: ${task.name}")
                        }

                        println("What do you want to do next?")
                        println("1. Create task")
                        println("2. Delete task")
                        println("3. Sign out")
                        val userSelection = scanner.nextInt()
                        scanner.nextLine()

                        when (userSelection){
                            1 -> {
                                println("Enter task:")
                                val newTask = scanner.nextLine()
                                if (db.addTask(newTask, user)){
                                    println("Task $newTask added successfully!")
                                }else{
                                    println("Unable to add task!")
                                }
                            }
                            2 -> {
                                println("Enter task you want to delete: ")
                                val taskId = scanner.nextInt()
                                val success = db.deleteTask(taskId)

                                if (success){
                                    println("Task deleted")
                                }else{
                                    println("Unable to delete requested task")
                                }

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
            2 -> {
                // Register
                println("Not yet")
            }
            3 -> {
                println("Thanks for using the app!")
                break
            }
            else -> {
                println("Unknown command!")
            }
        }
    }

}