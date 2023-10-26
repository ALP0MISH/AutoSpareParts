@file:Suppress("DEPRECATION")

package com.example.autospareparts.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.autospareparts.presentation.screens.main.MainUIState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun IncludeMainBottom(
    uiState: MainUIState.Loaded,
    scrollState: ScrollState,
    navigateToDetailsScreen: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val moviesList = listOf(
        uiState.nowPlayingMovies,
        uiState.upComingMovies,
        uiState.topRatedMovies,
        uiState.popularMovies,
    )
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
        TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),)
    }
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = defaultIndicator,
        modifier = Modifier,
        backgroundColor = Color.Transparent
    ) {
        moviesList.forEachIndexed { index, _ ->
            val header = getPagerHeaderByPosition(index)
            Tab(
                text = {
                    Text(
                        text = header,
                        style = MaterialTheme.typography.body1.copy(color = Color.White)
                    )
                }, selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
    HorizontalPager(
        pageCount = moviesList.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .nestedScroll(remember {
        object : NestedScrollConnection {
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                return if (available.y > 0) Offset.Zero else Offset(
                    x = 0f,
                    y = -scrollState.dispatchRawDelta(-available.y)
                )
            }
        }
    })
    ) { position ->
        val currentMovies = moviesList[position]
        LazyVerticalGrid(
            modifier = modifier.fillMaxWidth(),
            columns = GridCells.Fixed(count = 3),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            userScrollEnabled = false,
            contentPadding = PaddingValues(bottom = 40.dp)
        ) {
            items(items = currentMovies) { movieDomain ->
                PosterPathInclude(
                    movies = movieDomain,
                    navigateToDetailsScreen = navigateToDetailsScreen
                )
            }
        }
    }
}

@Composable
fun getPagerHeaderByPosition(position: Int): String = when (position) {
    0 -> "Now playing"
    1 -> "Upcoming"
    2 -> "Top rated"
    else -> "Popular"
}
