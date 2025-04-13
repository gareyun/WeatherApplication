package com.example.weatherapp.repositories

import com.example.weatherapp.network.WeatherApiService
import com.example.weatherapp.models.WeatherResponse


class WeatherRepository(private val apiService: WeatherApiService)  {
    suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponse = apiService.getWeather(latitude, longitude)
}