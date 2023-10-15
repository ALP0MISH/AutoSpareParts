package com.example.autospareparts.presentation.destinations

import BottomNavigationBarDestinations
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.autospareparts.presentation.screens.details_screen.DetailsScreen
import com.example.autospareparts.presentation.screens.details_screen.DetailsViewModel
import com.example.autospareparts.presentation.screens.watch_list_screen.WatchListScreen
import com.example.autospareparts.presentation.screens.main.MainScreen
import com.example.autospareparts.presentation.screens.main.MainViewModel
import com.example.autospareparts.presentation.screens.seach_screen.SearchScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
) {
    val viewModel: MainViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = BottomNavigationBarDestinations.Main.route
    ) {
        composable(route = BottomNavigationBarDestinations.Main.route) {
            MainScreen(
                navigateToSearchScreen = {
                    navController.navigate(BottomNavigationBarDestinations.Search.route)
                },
                uiStateFlow = viewModel.uiStateFlow,
                fetchMovies = viewModel::fetchAllMovies,

                navigateToDetailsScreen = { movieId ->
                    Log.i("Baha", "$movieId")
                    navController.navigate("${DetailsScreenDestination.route}/$movieId")
                }
            )
        }
        composable(route = BottomNavigationBarDestinations.Search.route) {
            SearchScreen()
        }
        composable(route = BottomNavigationBarDestinations.WatchList.route) {
            WatchListScreen()
        }
        composable(
            route = DetailsScreenDestination.routeWithArgs,
            arguments = DetailsScreenDestination.arguments
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments
                ?.getInt(DetailsScreenDestination.movieId)
                ?: 0
            val detailViewModel: DetailsViewModel = hiltViewModel()

            DetailsScreen(
                uiStateFlow = detailViewModel.uiStateFlow,
                fetchMovies ={ detailViewModel.fetchMovieByID(movieId)},
                addOrDelete = { detailViewModel.addOrDeleteMovie(movieId) }
            )
        }
    }
}
