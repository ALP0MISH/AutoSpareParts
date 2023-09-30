package com.example.autospareparts.presentation.screens.splash_screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.autospareparts.R
import com.example.autospareparts.presentation.screens.main.MainScreen
import kotlinx.coroutines.delay

@Composable
fun Navigation(
) {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "splash_screen") {
//        composable("splash_screen") {
//            SplashScreen(navController = navController)
//        }
//        composable("main_screen") {
//            Box(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Text(
//                    text = "hello",
//                    color = Color.White,
//                    fontSize = 12.sp
//                )
//            }
//            MainScreen()
//        }
//    }
//}
}

//@Composable
//fun SplashScreen(navController: NavController) {
//    val scale = remember {
//        Animatable(0f)
//    }
//    LaunchedEffect(key1 = true) {
//        scale.animateTo(
//            targetValue = 0.3f,
//            animationSpec = tween(
//                durationMillis = 500,
//                easing = {
//                    OvershootInterpolator(2f).getInterpolation(it)
//                }
//            )
//        )
//        delay(3000L)
//        navController.navigate("main_screen")
//
//    }
//    Box(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//        Image(
//            modifier = Modifier
//                .fillMaxSize()
//                .scale(scale.value),
//            painter = painterResource(id = R.drawable.splash_icon),
//            contentDescription = null,
//
//        )
//    }
//}
