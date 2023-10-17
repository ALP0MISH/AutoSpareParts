package com.example.autospareparts.presentation.screens.main_root_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.autospareparts.presentation.destinations.BottomBar
import com.example.autospareparts.presentation.destinations.BottomNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainRootScreen(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomBar(navController)
        }
    ) { innerPaddings ->
        BottomNavGraph(
            modifier = Modifier.padding(innerPaddings),
            navController = navController,
        )
    }
}