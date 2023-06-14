package db


import dao.historys
import dao.users
import model.History
import model.User
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.*

class DatabaseConnection {

    private val connectionString = "jdbc:mysql://localhost:3306/weather"
    private val user = "root"
    private val pass = "Kopika420!"
    private var connection: Database = Database.connect(
        url = connectionString,
        user = user,
        password = pass
    )

    fun getUserByUsername(userName: String): User? {
        return connection.users.find {
            it.username eq userName
        }
    }

    fun getUserById(userId: Int): User?{
        return connection.users.find {
            it.id eq userId
        }
    }

    fun createNewUser(username: String, password: String, location: String): Boolean {
        return if(getUserByUsername(username) == null){
            val newUser = User {
                this.username = username
                this.password = password
                this.location = location
            }
            connection.users.add(newUser)
            true
        }else{
            false
        }
    }

//    fun addHistory(queriedCity: String, authenticatedUserId: Int, ){
//        connection.historys.add(
//            History {
//                location = queriedCity
//                userId = authenticatedUserId
//            }
//        )
//    }
}