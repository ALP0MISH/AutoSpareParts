package com.example.autospareparts.presentation.destinations

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destination {
    val route: String
    val routeWithArgs: String
}

object MainScreen : Destination {
    override val route: String = "main_screen"
    override val routeWithArgs: String = route
}

object SearchScreen : Destination {
    val argumentTypeArg = "movieId"

    override val route: String = "search_screen"
    override val routeWithArgs: String = "$route/${argumentTypeArg}"
    val arguments = listOf(navArgument(argumentTypeArg) { type = NavType.StringType })
}