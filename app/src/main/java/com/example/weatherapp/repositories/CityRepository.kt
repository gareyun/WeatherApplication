package com.example.weatherapp.repositories

import com.example.weatherapp.network.CityApiService
import com.example.weatherapp.models.NetworkCity

class CityRepository(private val apiService: CityApiService) {
    suspend fun getCityByName (name: String): List<NetworkCity> = apiService.getCity(name)
}