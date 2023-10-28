package com.example.moviesapp.presentation.screens.watch_list_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviesapp.R
import com.example.moviesapp.presentation.screens.watch_list_screen.component.IsVisiblyWatchListItem
import com.example.moviesapp.presentation.screens.watch_list_screen.component.WatchListIncludeItem
import com.example.moviesapp.presentation.theme.Background
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WatchListScreen(
    modifier: Modifier =Modifier ,
    navigateToBack: () -> Unit,
    navigateToDetailsScreen: (Int) -> Unit,
    uiStateFlow: StateFlow<WatchListUIState>
) {
    val uiState = uiStateFlow.collectAsStateWithLifecycle().value
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
            .padding(top = 10.dp)
            .padding(horizontal = 24.dp)

    ) {
        Row(
            modifier = Modifier
        ) {
            IconButton(
                onClick = { navigateToBack() },
                modifier = Modifier.size(24.dp),
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null,
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
        if (uiState.movies.isEmpty()) {
            IsVisiblyWatchListItem()
        } else {
            LazyColumn {
                items(
                    items = uiState.movies
                ) { movie ->
                    WatchListIncludeItem(
                        navigateToDetailsScreen = navigateToDetailsScreen,
                        posterUrl = movie.posterPath,
                        movieId = movie.id,
                        title = movie.originalTitle,
                        voteAverage = movie.voteAverage.toString(),
                        releaseDate = movie.releaseDate
                    )
                }
            }
        }
    }
}