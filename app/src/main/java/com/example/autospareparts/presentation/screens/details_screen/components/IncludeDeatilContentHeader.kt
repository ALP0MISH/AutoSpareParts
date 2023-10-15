package com.example.autospareparts.presentation.screens.details_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.autospareparts.presentation.screens.details_screen.DetailScreenUiState


@Composable
fun DetailScreenComponents(
    uiState: DetailScreenUiState.Loaded,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(375.dp)
            .padding(top = 28.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp)),
            model = uiState.movies.backdropPath,
            contentDescription = null
        )
        AsyncImage(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(25.dp)),
            model = uiState.movies.posterPath,
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .padding(top = 240.dp)
                .padding(start = 160.dp),
            text = uiState.movies.originalTitle,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
    Spacer(modifier = Modifier.height(16.dp))

    Row(
        modifier = Modifier.padding(start = 63.dp)
    ) {
        Icon(
            Icons.Default.DateRange, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = uiState.movies.releaseDate,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            Icons.Filled.AccessAlarm, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "${uiState.movies.runtime} minute",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
    }
}