package com.example.autospareparts.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.autospareparts.R
import com.example.autospareparts.presentation.components.HorizontalPagerWithIndicators
import com.example.autospareparts.presentation.components.Item
import com.example.autospareparts.presentation.components.SearchTextField
import com.example.autospareparts.presentation.theme.Background
import kotlinx.coroutines.flow.StateFlow


@Composable
fun MainScreen(
    navigateToSearchScreen: () -> Unit,
    navigateToDetailsScreen: (Int) -> Unit,
    fetchMovies: () -> Unit,
    uiStateFlow: StateFlow<MainUIState>,
) {
    val lazyListState = rememberLazyListState()
    val fullScreenModifier = Modifier
        .background(Background)
        .fillMaxSize()

    when (val uiState = uiStateFlow.collectAsStateWithLifecycle().value) {
        is MainUIState.Loading -> {
            LoadingMainScreen(
                modifier = fullScreenModifier
            )
        }

        is MainUIState.Loaded -> LoadedMainScreen(
            uiState = uiState,
            navigateToSearchScreen = navigateToSearchScreen,
            modifier = fullScreenModifier,
            navigateToDetailsScreen = navigateToDetailsScreen,
        )

        is MainUIState.Error -> ErrorMainScreen(
            errorMessage = uiState.message,
            fetchMovies = fetchMovies,
            modifier = fullScreenModifier
        )
    }
}


@Composable
fun LoadingMainScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun LoadedMainScreen(
    uiState: MainUIState.Loaded,
    navigateToSearchScreen: () -> Unit,
    navigateToDetailsScreen: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(top = 24.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.what_do_you_want_to_watch),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontSize = 20.sp,
            ),
            textAlign = TextAlign.Center
        )
        val (value, onValueChange) = remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(24.dp))

        SearchTextField(
            value = value,
            onValueChange = onValueChange,
            navigateToSearchScreen = navigateToSearchScreen
        )
        Spacer(modifier = Modifier.height(20.dp))

        HorizontalPagerWithIndicators(movies = uiState.popularMovies, navigateToDetailsScreen = navigateToDetailsScreen)
        Spacer(modifier = Modifier.height(10.dp))
       // Item(uiState = uiState,navigateToDetailsScreen = navigateToDetailsScreen)
    }
}


@Composable
fun ErrorMainScreen(
    errorMessage: String,
    fetchMovies: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = errorMessage,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = fetchMovies) {
            Text(
                text = stringResource(id = R.string.retry),
                style = MaterialTheme.typography.titleLarge
            )

        }
    }
}
