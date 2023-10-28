package com.example.moviesapp.presentation.screens.details_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.moviesapp.R
import com.example.moviesapp.domain.models.PeopleDomain
import com.example.moviesapp.presentation.components.ReviewsFilterPopup
import com.example.moviesapp.presentation.components.ReviewsItemList
import com.example.moviesapp.presentation.screens.details_screen.components.DetailScreenComponents
import com.example.moviesapp.presentation.screens.details_screen.components.DetailTabBar
import com.example.moviesapp.presentation.theme.Background
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
@Composable
fun DetailsScreen(
    fetchMovies: () -> Unit,
    addOrDelete: () -> Unit,
    onFilterClick: (SortByItems) -> Unit,
    navigateToBack: () -> Unit,
    uiStateFlow: StateFlow<DetailScreenUiState>,
) {
    val fullScreenModifier = Modifier.background(Background)

    LaunchedEffect(key1 = Unit) { fetchMovies() }
    when (val uiState = uiStateFlow.collectAsStateWithLifecycle().value) {
        is DetailScreenUiState.Loading -> {
            LoadingScreen(modifier = fullScreenModifier)
        }

        is DetailScreenUiState.Loaded -> {
            LoadedScreen(
                modifier = fullScreenModifier,
                uiState = uiState,
                addOrDelete = addOrDelete,
                isSaved = uiState.isSaved,
                navigateToBack = navigateToBack,
                onFilterClick = onFilterClick
            )
        }

        is DetailScreenUiState.Error -> {
            ErrorScreen(
                errorMessage = uiState.message, fetchMovies = fetchMovies
            )
        }
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
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
        modifier = modifier, contentAlignment = Alignment.Center
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoadedScreen(
    addOrDelete: () -> Unit,
    isSaved: Boolean,
    onFilterClick: (SortByItems) -> Unit,
    navigateToBack: () -> Unit,
    uiState: DetailScreenUiState.Loaded,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    var screenHight: Dp

    BoxWithConstraints(
        modifier = modifier.fillMaxSize()
    ) {
        screenHight = maxHeight
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(state = scrollState)
        ) {
            Column {
                Row(
                    modifier = modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 24.dp)
                ) {
                    IconButton(modifier = Modifier.size(24.dp), onClick = { navigateToBack() }) {
                        Icon(
                            Icons.Default.ArrowBack, contentDescription = null, tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.padding(start = 134.dp))

                    Text(
                        text = stringResource(id = R.string.detail),
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(modifier = Modifier.size(24.dp), onClick = { addOrDelete() }) {
                        Icon(
                            painter = painterResource(id = if (isSaved) R.drawable.movie_save_icon else R.drawable.not_saved_icon),
                            contentDescription = null,
                            tint = if (isSystemInDarkTheme()) Color.White
                            else Color.White
                        )
                    }
                }
                DetailScreenComponents(
                    uiState = uiState
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.height(screenHight)
            ) {
                ScrollableTabRow(
                    selectedTabIndex = pagerState.currentPage,
                    containerColor = Color.Transparent,
                    modifier = Modifier.fillMaxWidth(),
                    indicator = { tabPositions ->
                        Box(
                            modifier = Modifier
                                .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                                .height(4.dp)
                                .padding(horizontal = 8.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.background,
                                    shape = RoundedCornerShape(8.dp)
                                )
                        )
                    },
                    divider = {
                        Spacer(modifier = Modifier.height(4.dp))
                    },
                    edgePadding = 0.dp
                ) {
                    uiState.tabs.forEachIndexed { index, detailTabBar ->
                        Tab(modifier = Modifier.padding(16.dp),
                            selected = index == pagerState.currentPage,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }) {
                            Text(
                                text = stringResource(id = detailTabBar.titleResId),
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }
                }
                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .nestedScroll(remember {
                            object : NestedScrollConnection {
                                override fun onPreScroll(
                                    available: Offset, source: NestedScrollSource
                                ): Offset {
                                    return if (available.y > 0) Offset.Zero else Offset(
                                        x = 0f, y = -scrollState.dispatchRawDelta(-available.y)
                                    )
                                }
                            }
                        }
                        ), pageCount = uiState.tabs.size, state = pagerState
                ) { index ->
                    when (val tab = uiState.tabs[index]) {
                        is DetailTabBar.AboutMovie -> {
                            AboutMovie(overview = tab.about)
                        }

                        is DetailTabBar.Reviewers -> {
                            var isFilterClick by remember {
                                mutableStateOf(false)
                            }
                            Column {
                                Row(
                                    modifier = Modifier.padding(horizontal = 24.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.filter),
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.White
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Column {
                                        Icon(
                                            modifier = Modifier.clickable {
                                                isFilterClick = !isFilterClick
                                            },
                                            painter = painterResource(id = R.drawable.filter_icon),
                                            contentDescription = null,
                                            tint = Color.White
                                        )
                                        if (isFilterClick) ReviewsFilterPopup(onClick = { sort ->
                                            isFilterClick = false
                                            onFilterClick(sort)
                                        })
                                    }
                                }
                                ReviewsItemList(reviewsFlow = tab.reviewers)
                            }
                        }

                        is DetailTabBar.Casts -> {
                            PeopleList(people = tab.casts)
                        }

                        is DetailTabBar.Crews -> {
                            PeopleList(people = tab.crews)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AboutMovie(
    overview: String, modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .padding(top = 32.dp)
            .padding(horizontal = 38.dp),
        text = overview,
        style = MaterialTheme.typography.titleMedium.copy(
            color = Color.White, textAlign = TextAlign.Center
        )
    )
}

@Composable
fun PeopleList(
    people: List<PeopleDomain>, modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(65.dp)
    ) {
        items(
            items = people
        ) { people ->
            PeopleItem(people)
        }
    }
}

@Composable
fun PeopleItem(
    people: PeopleDomain, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = people.profile_path,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.dark_image_place_holder)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = people.name,
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}