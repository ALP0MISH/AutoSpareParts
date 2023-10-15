package com.example.autospareparts.presentation.screens.watch_list_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.autospareparts.R
import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.presentation.screens.details_screen.ErrorScreen
import com.example.autospareparts.presentation.screens.details_screen.LoadingScreen
import com.example.autospareparts.presentation.screens.watch_list_screen.component.WatchListIncludeItem
import com.example.autospareparts.presentation.theme.Background
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WatchListScreen(
    modifier: Modifier = Modifier,
    // fetchMovies: () -> Unit,
    uiStateFlow: StateFlow<WatchListUIState>
) {
    val fullScreenModifier = Modifier
        .background(Background)
    when (val uiState = uiStateFlow.collectAsStateWithLifecycle().value) {
        is WatchListUIState.Loading -> {
            LoadingScreen(modifier = fullScreenModifier)
        }

        is WatchListUIState.Loaded -> {
            LoadedScreen(
                modifier = fullScreenModifier,
                //  movie = uiState.searchMovie
            )
        }

        is WatchListUIState.Error -> {
            ErrorScreen(
                errorMessage = uiState.message,
                // fetchMovies = fetchMovies
            )
        }
    }
}


@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}


@Composable
fun ErrorScreen(
    errorMessage: String,
    //  fetchMovies: () -> Unit,
    modifier: Modifier = Modifier
        .background(Background)
        .fillMaxSize()
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material3.Text(
            text = errorMessage,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {}) {
            androidx.compose.material3.Text(
                text = stringResource(id = R.string.retry),
                style = MaterialTheme.typography.titleLarge,
            )

        }
    }
}

@Composable
fun LoadedScreen(
    modifier: Modifier = Modifier,
    // movie: MovieDomain,
) {
    val fullScreenModifier = Modifier
        .background(Background)
    Column(
        modifier = fullScreenModifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
        ) {
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
            //      WatchListIncludeItem(watchMovie = movie)
            //  IsVisiblyWatchListItem(modifier = Modifier.padding(start = 94.dp))
        }
    }
}