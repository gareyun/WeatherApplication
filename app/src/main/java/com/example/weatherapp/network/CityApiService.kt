package com.example.weatherapp.network

import com.example.weatherapp.models.NetworkCity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CityApiService {
    @GET("v1/city")
    suspend fun getCity(@Query("name") name: String, @Header("X-Api-Key") api: String = "hFZUAXkmYyP0ICdj9dmMMQ==oEyJG58oNEC0kGJu"): List<NetworkCity>
}