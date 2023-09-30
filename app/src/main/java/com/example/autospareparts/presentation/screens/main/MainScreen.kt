package com.example.autospareparts.presentation.screens.main

import BottomNavigationBar
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.autospareparts.R
import com.example.autospareparts.data.remote.POSTER_PATH_URL
import com.example.autospareparts.presentation.models.MovieUi
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun MainScreenPriview() {
    val viewModel: MainViewModel = hiltViewModel()
    MaterialTheme {
        MainScreen(navigateToSearchScreen = {}, uiStateFlow = viewModel.uiState)
    }
}

@Composable
fun MainScreen(
    navigateToSearchScreen: (String) -> Unit,
    uiStateFlow: StateFlow<MainScreenUiState>,
    modifier: Modifier = Modifier.background(
        color = if (isSystemInDarkTheme()) colorResource(id = R.color.grey)
        else colorResource(id = R.color.background_color)
    )
) {
    val uiState = uiStateFlow.collectAsStateWithLifecycle().value
    val fullScreenModifier = Modifier.fillMaxSize()
    val navController = rememberNavController()

    when (uiState) {
        is MainScreenUiState.Loading -> LoadingMainScreen(modifier = fullScreenModifier)

        is MainScreenUiState.Loaded -> LoadedMainScreen(
            movies = uiState.movies,
            navigateToSearchScreen = navigateToSearchScreen,
            modifier = fullScreenModifier,
        )

        is MainScreenUiState.Error -> ErrorMainScreen(
            errorMessage = uiState.message, modifier = fullScreenModifier
        )
    }
}

@Composable
fun LoadingMainScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoadedMainScreen(
    movies: List<MovieUi>,
    navigateToSearchScreen: (String) -> Unit,
    modifier: Modifier = Modifier.background(
        color = if (isSystemInDarkTheme()) colorResource(id = R.color.grey)
        else colorResource(id = R.color.background_color)
    )
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = modifier
                .padding(start = 50.dp)
                .padding(top = 6.dp),
            text = stringResource(id = R.string.what_do_you_want_to_watch),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default
            )
        )
        val (value, onValueChange) = remember { mutableStateOf("") }
        Spacer(modifier = Modifier.padding(top = 24.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 20.sp),
            shape = CircleShape,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search, contentDescription = null, tint = Color.White
                )
            },
            modifier = modifier
                .padding(horizontal = 40.dp)
                .padding(top = 28.dp)
                .width(327.dp)
                .clip(CircleShape)
                .background(Color.Blue)
                .clickable { navigateToSearchScreen("Test") },
            enabled = false,

            placeholder = {
                Text(
                    text = stringResource(id = R.string.start_search), color = Color.White
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = colorResource(id = R.color.search_background),
                unfocusedIndicatorColor = colorResource(id = R.color.search_background),
                cursorColor = colorResource(id = R.color.search_background),
                containerColor = colorResource(id = R.color.search_background)
            )
        )
        Spacer(modifier = Modifier.padding(start = 20.dp))
    }
    Row(
        modifier = Modifier
            .padding(top = 150.dp)
            .width(590.dp)
            .height(255.dp)
    ) {
        // Movies Pager
        val movieImageUrls = movies.map { movie -> POSTER_PATH_URL + movie.backdropPath }
        HorizontalPagerWithIndicators(images = movieImageUrls)
        Spacer(modifier = Modifier.padding(top = 40.dp))
        LazyRowComponent(
            movies = movies
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithIndicators(images: List<String>) {
    val pagerState = rememberPagerState()

    Box(
        modifier = Modifier
            .width(590.dp)
            .height(255.dp)
            .padding(horizontal = 10.dp)

    ) {
        HorizontalPager(pageCount = images.size, state = pagerState) { page ->
            val painter: Painter = rememberImagePainter(data = images[page])
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp)),
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            pageCount = images.size,
            pagerState = pagerState,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyRowComponent(movies: List<MovieUi>) {
    val imageState = rememberPagerState()
    val itemList = List(5) { index -> "Item ${index + 1}" }

    LazyRow {
        val texts = listOf(
            "Now Playing", "Upcoming", "Top Rated", "Popular"
        )
        items(texts) { text ->
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(18.dp),
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        }
    }
    LazyRow {
        items(movies) { movie ->
            Image(painter = rememberAsyncImagePainter(model = movie.posterPath), contentDescription = null)
        }
    }
}

@Composable
fun ErrorMainScreen(
    errorMessage: String, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(
            text = errorMessage, style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavigationBar.Main,
        BottomNavigationBar.Search,
        BottomNavigationBar.WatchList,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavigationBar, currentDestination: NavDestination?,

    navController: NavHostController
) {
    NavigationBarItem(label = {
        Text(text = screen.title)
    }, icon = {
        Icon(
            imageVector = screen.icon, contentDescription = "Navigation icon"
        )
    }, selected = true, onClick = {
        navController.navigate(screen.route) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    })
}

@Composable
fun Expiriment(
    viewModel: MainViewModel
) {

}