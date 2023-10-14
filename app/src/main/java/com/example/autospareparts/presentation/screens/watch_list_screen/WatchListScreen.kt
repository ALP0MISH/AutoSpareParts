package com.example.autospareparts.presentation.screens.watch_list_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.autospareparts.R
import com.example.autospareparts.presentation.theme.Background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WatchListScreen(
    modifier: Modifier = Modifier
) {
    val fullScreenModifier = Modifier
        .background(Background)
        .fillMaxSize()

    Column(
        modifier = fullScreenModifier
            .padding(top = 10.dp)
            .padding(horizontal = 24.dp)
    ) {
        Row {
            IconButton(
                modifier = modifier.size(24.dp),
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(120.dp))
            Text(
                text = stringResource(id = R.string.watch_list),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(215.dp))
            IsVisiblyWatchListItem(modifier = Modifier.padding(start = 94.dp))
        }
    }
}

@Composable
fun IsVisiblyWatchListItem(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = modifier.size(76.dp),
            painter = painterResource(id = R.drawable.watch_list_image),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.there_is_not_movie_yet),
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White, fontSize = 16.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.find_your_movie_by_type_title_categories_years_etc),
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 12.sp, color = colorResource(id = R.color.light_grey),
            ),
        )
    }
}
