package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

data class NetworkCity(
    @SerializedName("name") val name: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("country") val country: String,
    @SerializedName("population") val population: Long,
    @SerializedName("region") val region: String,
    @SerializedName("is_capital") val isCapital: String
)