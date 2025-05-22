package com.example.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.NetworkCity
import com.example.weatherapp.models.WeatherResponse
import com.example.weatherapp.repositories.CityRepository
import com.example.weatherapp.repositories.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val cityRepository: CityRepository,
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _cityCoordinates = MutableStateFlow<NetworkCity?>(null)
    val cityCoordinates: StateFlow<NetworkCity?> = _cityCoordinates

    private val _weatherData = MutableStateFlow<WeatherResponse?>(null)
    val weatherData: StateFlow<WeatherResponse?> = _weatherData

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadWeather(cityName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val cities = cityRepository.getCityByName(cityName)
                val city = cities.firstOrNull { it.name == cityName }
                _cityCoordinates.value = city

                city?.let {
                    val weather = weatherRepository.getWeather(it.latitude, it.longitude)
                    _weatherData.value = weather
                } ?: run {
                    _error.value = "Город не найден"
                }
            } catch (e: Exception) {
                _error.value = "Ошибка: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
