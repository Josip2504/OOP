import model.User
import org.ktorm.database.Database
import org.ktorm.entity.add
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

    fun addNewUser(userName: String, password: String): Boolean{
        val success = connection.users.add(
            User {
                name = userName
                this.password = password
            }
        )
        return success > 0
    }
}