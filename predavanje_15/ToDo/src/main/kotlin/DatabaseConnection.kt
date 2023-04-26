import org.ktorm.database.Database

class DatabaseConnection {


    private val connectionString = "jdbc:mysql://localhost:3306/todo"
    private val user = "root"
    private val pass = "Kopika420!"
    var connection: Database = Database.connect(
        url = connectionString,
        user = user,
        password = pass
    )


}