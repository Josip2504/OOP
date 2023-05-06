package controller

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import io.ktor.client.request.forms.*
import model.User
import model.WeatherResults
import repository.Repository
import util.AuthenticationService
import util.Lce

class WeatherController(
    private val repository: Repository,
    private val authService: AuthenticationService
) {

    private val _weatherState = mutableStateOf<Lce<WeatherResults>?>(null)
    val weatherState: State<Lce<WeatherResults>?> get() = _weatherState

    fun setState(newState: Lce<WeatherResults>?){
        _weatherState.value = newState
    }

    suspend fun weatherForCity(queriedCity: String): Lce<WeatherResults>{
        return repository.weatherForCity(queriedCity)
    }

    fun getUserById(id: Int): User? {
        return repository.getUserById(id)
    }



}