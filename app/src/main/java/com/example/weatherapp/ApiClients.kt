package com.example.weatherapp

import com.example.weatherapp.network.CityApiService
import com.example.weatherapp.network.WeatherApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object WeatherClient {
    private const val BASE_URL = "https://api.open-meteo.com"

    val instance: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }
}

object CityClient {
    private const val BASE_URL = "https://api.api-ninjas.com"

    val instance: CityApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CityApiService::class.java)
    }
}