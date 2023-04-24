import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

class DatabaseConnection {
    private var connectionString = "jdbc:mysql://localhost:3306/animal_owners"
    private var dbUsername = "root"
    private var dbPassword = "1234"
    var connection: Connection? = null

    fun connect(){
        connection = DriverManager.getConnection(connectionString, dbUsername, dbPassword)
    }

    fun executeStatement(query: String): ResultSet? {
        val statement = connection?.createStatement()
        return statement?.executeQuery(query)
    }

    fun executeStatement(query: String, vararg options: String): ResultSet? {
        val statement = connection?.prepareStatement(query)
        options.forEachIndexed { index, option ->
            statement?.setString(index+1, option)
        }
        return statement?.executeQuery()
    }

    fun close() {
        connection?.close()
    }

}