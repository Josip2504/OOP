import org.json.JSONObject

fun main() {
    val jsonString = """
    {
        "name": "John",
        "age": 30,
        "city": "New York"
    }
    """.trimIndent()

    val json = JSONObject(jsonString)
    val name = json.getString("name")
    val age = json.getInt("age")
    val city = json.getString("city")

    println("Name: $name")
    println("Age: $age")
    println("City: $city")
}