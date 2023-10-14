@file:Suppress("DEPRECATION")

package com.example.autospareparts.presentation.components

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.autospareparts.presentation.screens.main.MainUIState
import com.example.autospareparts.presentation.theme.Background
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

//
//@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
//@Composable
//fun TabBar(
//    onChangeType: (FetchType) -> Unit,
//    movies: MainUIState.Loaded,
//    navigateToDetailsScreen: (Int) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    val moviesList = listOf(
//        movies.nowPlayingMovies,
//        movies.upComingMovies,
//        movies.topRatedMovies,
//        movies.popularMovies,
//    )
//    val pagerState = rememberPagerState()
//    val header = gerPagerHeaderByPosition(pagerState.currentPage)
//    val pagerPage = remember { mutableStateOf(0) }
//    val pages = TextTypeUi.getAllTextType()
//    val coroutineScope = rememberCoroutineScope()
//    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
//        TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
//    }
//    LaunchedEffect(key1 = pagerState.currentPage) { pagerPage.value = pagerState.currentPage }
//    val indicator = @Composable { tabPositions: List<TabPosition> ->
//        CustomIndicator(tabPositions, pagerState)
//    }
//    Column {
//        ScrollableTabRow(
//            modifier = Modifier.height(50.dp),
//            selectedTabIndex = minOf(pages.count(), pagerPage.value),
//            backgroundColor = Background,
//            indicator = defaultIndicator,
//            divider = {
//                Spacer(modifier = Modifier.height(5.dp))
//            }
//        ) {
//            pages.forEachIndexed { index, textType ->
//                Tab(modifier = Modifier.zIndex(5f), text = {
//                    Text(
//                        text = header,
//                        style = MaterialTheme.typography.body1.copy(color = Color.White)
//                    )
//                }, selected = pagerState.currentPage == index, onClick = {
//                    coroutineScope.launch {
//                        pagerState.animateScrollToPage(index)
//                        onChangeType(textType.type)
//                    }
//                }
//                )
//            }
//        }
//        HorizontalPager(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(all = 12.dp),
//            pageCount = pages.size,
//            state = pagerState
//        ) {
//            LazyVerticalGrid(columns = GridCells.Fixed(count = 3)) {
//                items(items = moviesList) { movie ->
//                    AsyncImage(
//                        modifier = Modifier
//                            .padding(horizontal = 12.dp, vertical = 8.dp)
//                            .width(124.dp)
//                            .height(151.dp)
//                            .clip(RoundedCornerShape(16.dp))
//                            .clickable { navigateToDetailsScreen(movie.size) },
//                        model = movie.size,
//                        contentScale = ContentScale.Crop,
//                        contentDescription = null
//                    )
//                }
//            }
//        }
//    }
//}
//
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage, label = "")
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .border(BorderStroke(2.dp, Color.Black), RoundedCornerShape(50))
            .zIndex(1f)
    )
}

//
@Composable
fun gerPagerHeaderByPosition(position: Int): String = when (position) {
    0 -> "Now playing"
    1 -> "Upcoming"
    2 -> "Top rated"
    else -> "Popular"

}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun Item(
    uiState: MainUIState.Loaded,
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
    val header = gerPagerHeaderByPosition(pagerState.currentPage)
    val pagerPage = remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()
    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
        TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
    }
    LaunchedEffect(key1 = pagerState.currentPage) { pagerPage.value = pagerState.currentPage }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }
    Column {
        ScrollableTabRow(selectedTabIndex = minOf(header.count(), pagerPage.value),
            backgroundColor = Background,
            indicator = defaultIndicator,
            divider = {
                Spacer(modifier = Modifier.height(5.dp))
            }) {
            moviesList.forEachIndexed { index, header ->
                Tab(modifier = Modifier.zIndex(4f), text = {
                    Text(
                        text = header.toString(),
                        style = MaterialTheme.typography.body1.copy(color = Color.White)
                    )
                }, selected = pagerState.currentPage == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                        header
                    }
                })
            }
        }
        HorizontalPager(
            pageCount = moviesList.size, state = pagerState
        ) { position ->
            val currentMovies = moviesList[position]
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 3),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(items = currentMovies) { movieDomain ->
                    posterPathInclude(
                        movies = movieDomain, navigateToDetailsScreen = navigateToDetailsScreen
                    )
                }
            }
//                items(items = currentMovies.map { it.posterPath },
//                    {  MovieItemList(
//                            movies = key,
//                            navigateToDetailsScreen = navigateToDetailsScreen)
//                    }
//                )
        }
    }
}

