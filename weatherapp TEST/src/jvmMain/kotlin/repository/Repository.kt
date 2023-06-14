package repository

import dao.WeatherResponse
import db.DatabaseConnection
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import model.User
import model.WeatherResults
import util.Lce
import util.WeatherTransformer


class Repository(
    private val db: DatabaseConnection,
    private val client: HttpClient = defaultHttpClient
) {

    private val apiKey = "10b98aeeebfb4094a41172245230205"

    private val transformer = WeatherTransformer()

    companion object {
        val defaultHttpClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(
                    json = kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }

    suspend fun weatherForCity(city: String): Lce<WeatherResults> {
        return try {
            val result = getWeatherForCity(city)
            val content = transformer.transform(result)
            Lce.Content(content)
        }catch (e: Exception){
            e.printStackTrace()
            Lce.Error(e)
        }
    }

    private suspend fun getWeatherForCity(city: String): WeatherResponse{
        return client.get("https://api.weatherapi.com/v1/forecast.json" +
                "?key=$apiKey" +
                "&q=$city" +
                "&days=5" +
                "&aqi=no" +
                "&alerts=no").body()
    }

    fun addUser(username: String, password: String, location: String): Lce<String> {
        return if(db.createNewUser(username, password, location)){
            Lce.Content("Successfully registered!")
        }else{
            Lce.Error(Throwable("User already exists!"))
        }
    }

    fun getUserById(id: Int): User? {
        return db.getUserById(id)
    }

}