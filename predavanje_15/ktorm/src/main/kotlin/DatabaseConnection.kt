import org.ktorm.database.Database

class DatabaseConnection {

    private val connectionString = "jdbc:mysql://localhost:3306/animal_owners"
    private val user = "root"
    private val pass = "1234"
    var connection: Database = Database.connect(
        url = connectionString,
        user = user,
        password = pass
    )

}