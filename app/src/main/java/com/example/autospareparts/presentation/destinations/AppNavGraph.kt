package com.example.autospareparts.presentation.destinations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autospareparts.presentation.screens.main.MainScreen
import com.example.autospareparts.presentation.screens.main.MainViewModel
import com.example.autospareparts.presentation.screens.seach_screen.SearchScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = MainScreen.route
    ) {
        composable(route = MainScreen.routeWithArgs) {
            val viewModel: MainViewModel = hiltViewModel()
            MainScreen(
                navigateToSearchScreen = { argument ->
                    navController.navigate(SearchScreen.route) },
                uiStateFlow = viewModel.uiState)
        }
        composable(route = SearchScreen.route, arguments = SearchScreen.arguments) { navBackStackEntry ->
            val argument = navBackStackEntry.arguments?.getString(SearchScreen.argumentTypeArg)
            SearchScreen()
        }
    }
}