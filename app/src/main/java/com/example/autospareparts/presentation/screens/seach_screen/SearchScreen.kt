package com.example.autospareparts.presentation.screens.seach_screen

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.autospareparts.R
import com.example.autospareparts.presentation.theme.Background

//@Preview
//@Composable
//fun SearchScreenPreview() {
//    MaterialTheme {
//        SearchScreen()
//    }
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
) {
    val fullScreenModifier = Modifier
        .background(Background)
        .fillMaxSize()

    Column(
        modifier = fullScreenModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .padding(top = 10.dp)
                .padding(horizontal = 24.dp)
        ) {
            val navController: NavHostController = rememberNavController()
            val isBackButtonVisible by remember {
                derivedStateOf { navController.previousBackStackEntry != null }
            }
            IconButton(
                modifier = modifier.size(24.dp),
                onClick = { isBackButtonVisible }
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.padding(start = 134.dp))
            Text(
                text = stringResource(id = R.string.search),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(modifier = modifier.size(24.dp), onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
        val (value, onValueChange) = remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = modifier
                .padding(horizontal = 24.dp)
                .padding(top = 36.dp)
                .fillMaxWidth()
                .clip(CircleShape),
            value = value,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp),
            shape = RoundedCornerShape(16.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null, tint = Color.White
                )
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.start_search),
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
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
    }
}

@Composable
fun IsVisiblyItem(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(144.dp))
        Image(
            painter = painterResource(id = R.drawable.search_image),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.we_are_sorry_we_can_not_find_the_movie),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp,
                fontWeight = FontWeight.Bold, color = Color.White), textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.find_your_movie_by_type_title_categories_years_etc),
            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp,
                color = colorResource(id = R.color.light_grey))
        )
    }
}




