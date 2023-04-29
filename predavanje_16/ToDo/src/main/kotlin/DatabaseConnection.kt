import model.Task
import model.User
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import schema.Tasks
import schema.Tasks.userId
import schema.tasks
import schema.users

class DatabaseConnection {


    private val connectionString = "jdbc:mysql://localhost:3306/todo"
    private val user = "root"
    private val pass = "Kopika420!"
    private var connection: Database = Database.connect(
        url = connectionString,
        user = user,
        password = pass
    )

    fun getUserByUsername(userName: String): User? {
        return connection.users.find {
            it.name eq userName
        }
    }

    fun getUserTasksList(userId: Int): List<Task> {
        return connection.tasks.filter {
            it.userId eq userId
        }.toList()
    }

    fun getUsersTasks(UserId: Int): EntitySequence<Task, Tasks> {
        return connection.tasks.filter {
            it.userId eq userId
        }
    }

    fun getTaskById(taskId: Int): Task? {
        return  connection.tasks.find {
            it.id eq taskId
        }
    }

    fun addTask(newTask: String, user: User): Boolean {
        val succes = connection.tasks.add(
            Task {
                name = newTask
                this.user = user
            }
        )
        return succes > 0
    }

    fun deleteTask(taskId: Int): Boolean {
        val succes = getTaskById(taskId)?.delete()?: -1
        return succes > 0
    }

}