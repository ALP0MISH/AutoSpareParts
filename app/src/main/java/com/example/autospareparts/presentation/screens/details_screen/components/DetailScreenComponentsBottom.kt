package com.example.autospareparts.presentation.screens.details_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Tab
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.autospareparts.presentation.screens.details_screen.DetailScreenUiState
import kotlinx.coroutines.launch

//@Preview
//@Composable
//fun DetailTabBarPreview(){
//    val viewmodel : DetailsViewModel = hiltViewModel()
//    MaterialTheme{
//        DetailTabBar(
//
//        )
//    }


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailTabBar(
    movies: DetailScreenUiState.Loaded
) {
    val movieList = listOf(
        movies.movies.overview,
        movies.movies.releaseDate
    )
    val movieTextList = listOf(
        "Overview",
        "Homepage"
    )
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    TabRow(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        containerColor = Color.Transparent,

        selectedTabIndex = pagerState.currentPage
    ) {
        movieTextList.forEachIndexed { index, title ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(text = title)
                }
            )
        }
    }
    HorizontalPager(
        modifier = Modifier.padding(horizontal = 17.dp),
        pageCount = movieList.size, state = pagerState
    ) { position ->
        val currentDescription = movieList[position]
        DescriptionText(description = currentDescription)
    }
}

@Composable
fun DescriptionText(
    description: String,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Text(
        text = description,
        modifier = modifier.padding(top = 8.dp),
        style = MaterialTheme.typography.bodyLarge,
        color = Color.White
    )
}