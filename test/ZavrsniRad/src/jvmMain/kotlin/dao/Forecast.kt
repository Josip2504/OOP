package dao

import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    val forecastDays: List<ForecastDay>
)
