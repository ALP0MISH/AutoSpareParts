import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationBarDestinations(
    val route: String,
    val title: String,
    val icon: ImageVector,
    ) {
    object Main : BottomNavigationBarDestinations(
        route = "main",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Search : BottomNavigationBarDestinations(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object WatchList : BottomNavigationBarDestinations(
        route = "watch_list",
        title = "Watch List",
        icon = Icons.Filled.Bookmark
    )
}