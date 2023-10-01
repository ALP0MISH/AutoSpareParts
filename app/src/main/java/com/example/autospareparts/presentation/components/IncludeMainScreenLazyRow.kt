package com.example.autospareparts.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.example.autospareparts.data.remote.POSTER_PATH_URL
import com.example.autospareparts.presentation.models.FetchType
import com.example.autospareparts.presentation.models.MovieUi
import kotlinx.coroutines.launch

data class TabItem(
    val title: String, val type: FetchType, val screen: @Composable () -> Unit
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyRowMovies(
    movies: List<MovieUi>,){}
//) {
//    val pagerState = rememberPagerState()
//    val coroutineScope = rememberCoroutineScope()
//    val movieImageUrls = movies.map { movie -> POSTER_PATH_URL + movie.backdropPath }
//
//    val tabs = listOf(
//        TabItem(
//            title = "Now Playing",
//            screen = { LazyRowMovies(movies = movies) },
//            type = FetchType.NOW_PLAYING
//        ), TabItem(
//            title = "Upcoming",
//            screen = { LazyRowMovies(movies = movies) },
//            type = FetchType.UP_COMING
//        ), TabItem(
//            title = "Top Rated",
//            screen = { LazyRowMovies(movies = movies) },
//            type = FetchType.TOP_RATED
//        ), TabItem(
//            title = "Popular", screen = { LazyRowMovies(movies = movies) }, type = FetchType.POPULAR
//        )
//    )
//
////    Column(
////        modifier = Modifier.fillMaxWidth(),
////        horizontalAlignment = Alignment.CenterHorizontally,
////        verticalArrangement = Arrangement.Center
////    ) {
//        Image(
//            painter = rememberAsyncImagePainter(model = movieImageUrls), contentDescription = null
//        )
//        TabRow(
//            selectedTabIndex = pagerState.currentPage,
//        ) {
//            tabs.forEachIndexed { index, item ->
//                Tab(
//                    selected = index == pagerState.currentPage,
//                    text = { Text(text = item.title) },
//                    onClick = {
////                        viewModel.getMovies(item.type)
//                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
//                    },
//                )
//            }
//        }
//        HorizontalPager(
//            pageCount = tabs.size, state = pagerState
//        ) {
//            tabs[pagerState.currentPage].screen()
//        }
////    }
//}