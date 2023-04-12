import org.json.JSONArray
import org.json.JSONObject

fun main() {
    val filePath = "C:\\Users\\Mata\\Desktop\\Tecaj\\predavanje_10\\FileInput\\src\\main\\resources\\users.json"
    val json = getContentOfFile(filePath)
    val jsonArray = JSONArray(json)

    printAllUsers(jsonArray)

    val newUser = createNewUser("Đuro", 35, "Dubrovnik")

    jsonArray.put(newUser)

    createNewFile(filePath, jsonArray.toString())
}

fun createNewUser(name: String, age: Int, city: String): JSONObject {
    return JSONObject().put("name", name).put("age", age).put("city", city)
}

fun printAllUsers(jsonArray: JSONArray){
    jsonArray.forEach {
        it as JSONObject
        val name = it.getString("name")
        val age = it.getInt("age")
        val city = it.getString("city")

        println("User $name is $age years old and lives in $city")
    }
}