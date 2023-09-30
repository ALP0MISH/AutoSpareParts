package com.example.autospareparts.presentation.screens.seach_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.autospareparts.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    //   isVisible: Boolean,
    modifier: Modifier = Modifier.background(
        color = if (isSystemInDarkTheme())
            colorResource(id = R.color.grey)
        else colorResource(id = R.color.background_color)
    )
) {
    val navController = rememberNavController()
    Scaffold(
//        bottomBar = { BottomBar(navController = navController) }
    ) {
    }
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
        ) {
            Row(
                modifier = modifier
                    .padding(top = 10.dp)
                    .padding(start = 24.dp)
            ) {
                val navController: NavHostController = rememberNavController()
                val isBackButtonVisible by remember {
                    derivedStateOf {
                        navController.previousBackStackEntry != null
                    }
                }
                IconButton(
                    modifier = modifier.size(24.dp),
                    onClick = { isBackButtonVisible }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = if (isSystemInDarkTheme()) Color.Black else Color.White
                    )
                }
                Spacer(modifier = modifier.padding(start = 135.dp))
                Text(
                    text = stringResource(id = R.string.search),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 16.sp,
                        color = if (isSystemInDarkTheme()) Color.Black else Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = modifier.padding(start = 135.dp))
                IconButton(
                    modifier = modifier.size(24.dp),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = null,
                        tint = if (isSystemInDarkTheme()) Color.Black else Color.White
                    )
                }
            }
            val (value, onValueChange) = remember { mutableStateOf("") }
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(fontSize = 20.sp),
                shape = CircleShape,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                modifier = modifier
                    .padding(horizontal = 45.dp)
                    .padding(top = 36.dp)
                    .width(331.dp)

                    .clip(CircleShape)
                    .background(colorResource(id = R.color.search_background)),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.start_search),
                        color = Color.Gray
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = colorResource(id = R.color.search_background),
                    unfocusedIndicatorColor = colorResource(id = R.color.search_background),
                    cursorColor = colorResource(id = R.color.search_background),
                    containerColor = colorResource(id = R.color.search_background)
                )
            )
            IsVisiblyItem()
            //  if (isVisible) {
        }
        //    else Text(text = "text")
    }
}

@Composable
fun IsVisiblyItem(
    modifier: Modifier = Modifier
) {
    Column {
        Image(
            modifier = modifier
                .padding(horizontal = 154.dp)
                .padding(top = 144.dp)
                .size(80.dp),
            painter = painterResource(id = R.drawable.search_image),
            contentDescription = null,
        )
        Text(
            modifier = modifier
                .padding(start = 115.dp)
                .padding(top = 16.dp),
            text = stringResource(id = R.string.we_are_sorry_we_can_not_find_the_movie),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSystemInDarkTheme()) Color.Black else Color.White
            )
        )
        Text(
            modifier = modifier
                .padding(start = 120.dp)
                .padding(top = 8.dp),
            text = stringResource(id = R.string.find_your_movie_by_type_title_categories_years_etc),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 12.sp,
                color = colorResource(id = R.color.light_grey)
            )
        )
    }
}




