import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.autospareparts.R
import com.example.autospareparts.presentation.destinations.MainScreen
import com.google.accompanist.pager.HorizontalPagerIndicator

@Composable
fun HorizontalPagerWithIndicatorsScreen() {
    val images = listOf(
        R.drawable.search_image,
        R.drawable.splash_icon,
        R.drawable.search_image,
        R.drawable.splash_icon,
        R.drawable.search_image,
    )
    Column {
        HorizontalPagerWithIndicators(images)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithIndicators(images: List<Int>) {
    val pagerState = rememberPagerState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        HorizontalPager(pageCount = 5, state = pagerState) {
            Image(
                painter = painterResource(id = images[it]),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            pageCount = 5,
            pagerState = pagerState,
        )
    }
//    AnimatedContent(
//        targetState = tabSelected,
//        transitionSpec = {
//            fadeIn(
//                animationSpec = tween(600, easing = EaseIn)
//            ).with(
//                fadeOut(
//                    animationSpec = tween(600, easing = EaseOut)
//                )
//            ).using(
//                SizeTransform(
//                    clip = false,
//                    sizeAnimationSpec = { initialSize, targetSize ->
//                        tween(600, easing = EaseInOut)
//                    }
//                )
//            )
//        },
//        label = "",
//    ) { targetState ->
//        when (targetState) {
//            HorizontalPagerWithIndicators(images) -> MainScreen
//            HorizontalPagerWithIndicators(images) -> MainScreen
//            HorizontalPagerWithIndicators(images) -> MainScreen
//        }
//    }
}