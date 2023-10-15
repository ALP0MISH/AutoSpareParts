package com.example.autospareparts.presentation.screens.watch_list_screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.autospareparts.R
import com.example.autospareparts.presentation.models.MovieUi

//@Preview
//@Composable
//fun WatchListIncludeItemPreview() {
//    MaterialTheme {
//        WatchListIncludeItem()
//    }
//}

@Composable
fun WatchListIncludeItem(
    watchMovie: MovieUi,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
    ) {

        AsyncImage(
            modifier = modifier.height(120.dp),
            model = watchMovie.posterPath,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.dark_image_place_holder),
        )
        Column(
            modifier = Modifier
        ) {
            Text(
                text = watchMovie.title,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
            Row(
                modifier = Modifier
            ) {
                Icon(Icons.Default.AccessTime, contentDescription = null)
                Text(text = watchMovie.voteAverage.toString())
            }
            Row(
                modifier = Modifier
            ) {
                Text(text = watchMovie.releaseDate)
                Icon(Icons.Default.DateRange, contentDescription = null)
            }
        }
    }
}