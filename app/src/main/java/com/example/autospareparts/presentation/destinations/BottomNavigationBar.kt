
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationBar(
    val route: String,
    val title: String,
    val icon: ImageVector,

    ) {
    object Main : BottomNavigationBar(
        route = "main",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Search : BottomNavigationBar(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object WatchList : BottomNavigationBar(
        route = "watch_list",
        title = "WatchList",
        icon = Icons.Default.Star
    )
}