package com.example.autospareparts.presentation.screens.splash_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.autospareparts.R
import com.example.autospareparts.presentation.destinations.MainRootScreenDestination
import com.example.autospareparts.presentation.destinations.SplashScreenDestination
import com.example.autospareparts.presentation.theme.Background
import kotlinx.coroutines.delay

private const val SPLASH_SCREEN_SHOW_TIME = 300L

@Preview
@Composable
fun SplashScreenPreview() {
    MaterialTheme {
        SplashScreen(rememberNavController())
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        delay(SPLASH_SCREEN_SHOW_TIME)
        navController.navigate(MainRootScreenDestination.route) {
            popUpTo(route = SplashScreenDestination.route) {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(189.dp),
            painter = painterResource(id = R.drawable.splash_icon),
            contentDescription = null,
        )
    }
}
