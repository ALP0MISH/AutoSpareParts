package com.example.moviesapp.presentation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.presentation.screens.main_root_screen.MainRootScreen
import com.example.moviesapp.presentation.screens.splash_screen.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashScreenDestination.route
    ) {
        composable(route = SplashScreenDestination.route) {
            SplashScreen(navController)
        }

        composable(route = MainRootScreenDestination.route) {
            MainRootScreen()
        }
    }
}