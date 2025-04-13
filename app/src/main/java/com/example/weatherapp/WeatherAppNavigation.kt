package com.example.weatherapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.repositories.CityRepository
import com.example.weatherapp.repositories.WeatherRepository
import com.example.weatherapp.ui.screens.CityListScreen
import com.example.weatherapp.ui.theme.screens.WeatherScreen

@Composable
fun WeatherApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "cityList") {
        composable("cityList") {
            CityListScreen(
                onCityClick = { cityName, cityRu ->
                    navController.navigate("weatherScreen/$cityName/$cityRu")
                }
            )
        }
        composable("weatherScreen/{cityName}/{cityRu}") { backStackEntry ->
            val cityName = backStackEntry.arguments?.getString("cityName") ?: ""
            val cityRu = backStackEntry.arguments?.getString("cityRu") ?: ""
            WeatherScreen(
                cityRepository = CityRepository(CityClient.instance),
                weatherRepository = WeatherRepository(WeatherClient.instance),
                cityName = cityName,
                cityRu = cityRu,
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}