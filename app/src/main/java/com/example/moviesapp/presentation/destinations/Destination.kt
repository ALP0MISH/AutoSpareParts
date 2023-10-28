package com.example.moviesapp.presentation.destinations

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val route: String
}

object MainRootScreenDestination : Destination {
    override val route: String = "main_root_screen"
}

object SplashScreenDestination : Destination {
    override val route: String = "splash_screen"
}

object  DetailsScreenDestination : Destination {
     val movieId = "movieId"
    override val route: String = "detail_screen"
    val routeWithArgs = "$route/{$movieId}"
    val arguments = listOf(navArgument(movieId) { type = NavType.IntType })
}