package com.example.autospareparts.presentation

import HorizontalPagerWithIndicatorsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.autospareparts.presentation.destinations.AppNavGraph
import com.example.autospareparts.presentation.destinations.SearchScreen
import com.example.autospareparts.presentation.screens.main.MainScreen
import com.example.autospareparts.presentation.screens.main.MainScreenUiState
import com.example.autospareparts.presentation.screens.main.MainViewModel
import com.example.autospareparts.presentation.theme.AutoSparePartsTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AutoSparePartsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                      MainScreen(navigateToSearchScreen = { argument ->
                          navController.navigate(SearchScreen.route) }, uiStateFlow =viewModel.uiState )
                }
            }
        }
    }
}
