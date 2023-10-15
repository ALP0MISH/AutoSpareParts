package com.example.autospareparts.presentation.screens.details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BookmarkAdd
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.autospareparts.R
import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.presentation.screens.details_screen.components.DetailScreenComponents
import com.example.autospareparts.presentation.screens.details_screen.components.DetailTabBar
import com.example.autospareparts.presentation.screens.main.MainUIState
import com.example.autospareparts.presentation.theme.Background
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DetailsScreen(
    fetchMovies: () -> Unit,
    addOrDelete: () -> Unit,
    uiStateFlow: StateFlow<DetailScreenUiState>,
) {
    val fullScreenModifier = Modifier
        .background(Background)

    LaunchedEffect(key1 = Unit) { fetchMovies() }
    when (val uiState = uiStateFlow.collectAsStateWithLifecycle().value) {
        is DetailScreenUiState.Loading -> {
            LoadingScreen(modifier = fullScreenModifier)
        }

        is DetailScreenUiState.Loaded -> {
            LoadedScreen(
                modifier = fullScreenModifier, uiState = uiState,
                addOrDelete = addOrDelete,
                isSaved = uiState.isSaved
            )
        }

        is DetailScreenUiState.Error -> {
            ErrorScreen(
                errorMessage = uiState.message,
                fetchMovies = fetchMovies
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
    fetchMovies: () -> Unit,
    modifier: Modifier = Modifier
        .background(Background)
        .fillMaxSize()
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = errorMessage,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = fetchMovies) {
            Text(
                text = stringResource(id = R.string.retry),
                style = MaterialTheme.typography.titleLarge,
            )

        }
    }
}

@Composable
fun LoadedScreen(
    addOrDelete: () -> Unit,
    isSaved: Boolean,
    uiState: DetailScreenUiState.Loaded,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .padding(top = 10.dp)
                .padding(horizontal = 24.dp)
        ) {
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = {}
            ) {
                Icon(
                    Icons.Default.ArrowBack, contentDescription = null,
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.padding(start = 134.dp))

            Text(
                text = stringResource(id = R.string.detail),
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { addOrDelete() }
            ) {
                Icon(
                    painter = painterResource(id = if (isSaved) R.drawable.movie_save_icon else R.drawable.not_saved_icon),
                    contentDescription = null,
                    tint = if (isSystemInDarkTheme()) Color.White
                    else Color.Black
                )
            }
        }
        DetailScreenComponents(
            uiState = uiState
        )
        Spacer(modifier = Modifier.height(10.dp))

        DetailTabBar(
            movies = uiState
        )
    }
}