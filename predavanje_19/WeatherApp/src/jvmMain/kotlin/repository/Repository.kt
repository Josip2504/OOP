package repository

import dao.WeatherResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import model.WeatherResults
import util.Lce
import util.WeatherTransformer


class Repository(
    private val apiKey: String,
    private val client: HttpClient = defaultHttpClient,
) {

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

}