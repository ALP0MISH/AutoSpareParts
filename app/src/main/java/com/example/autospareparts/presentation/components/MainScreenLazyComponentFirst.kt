package com.example.autospareparts.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.autospareparts.domain.models.MovieDomain
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithIndicators(
    movies: List<MovieDomain>,
    navigateToDetailsScreen: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    Box(modifier = Modifier)
    {
        HorizontalPager(
            pageCount = movies.size,
            state = pagerState
        ) { page ->
            IncludeItem(movies = movies[page], navigateToDetailsScreen = navigateToDetailsScreen)
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            pageCount = movies.size,
            pagerState = pagerState,
            activeColor = Color.White,
            inactiveColor = Color.White.copy(alpha = 0.5f)
        )
    }
}

@Composable
fun MovieItemList(
    movies: List<MovieDomain>,
    navigateToDetailsScreen: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(columns = GridCells.Fixed(count = 3)) {
        this.items(
            items = movies
        ) { item ->
            posterPathInclude(movies = item, navigateToDetailsScreen = navigateToDetailsScreen)
        }
    }
}


@Composable
fun IncludeItem(
    movies: MovieDomain,
    navigateToDetailsScreen: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(255.dp)
    ) {
        AsyncImage(
            model = movies.backdropPath,
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth()
                .height(225.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable { navigateToDetailsScreen(movies.id) },
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun posterPathInclude(
    movies: MovieDomain,
    navigateToDetailsScreen: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = movies.posterPath,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .clickable { navigateToDetailsScreen(movies.id) },
        )
    }
}