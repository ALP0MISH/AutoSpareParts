package com.example.autospareparts.presentation.screens.details_screen.components

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Tab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.autospareparts.R
import com.example.autospareparts.domain.models.PeopleDomain
import com.example.autospareparts.domain.models.ReviewsDomain
import com.example.autospareparts.presentation.screens.details_screen.DetailScreenUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
sealed class DetailTabBar(
    @StringRes
    val titleResId: Int
) {
    data class AboutMovie(
        val about: String
    ):DetailTabBar(R.string.about_movie)
    data class Reviewers(
        val reviewers: StateFlow<List<ReviewsDomain>>
    ):DetailTabBar(R.string.reviews)
    data class Casts(
        val casts : List<PeopleDomain>
    ):DetailTabBar(R.string.casts)

    data class Crews(
        val crews : List<PeopleDomain>
    ):DetailTabBar(R.string.crews)
}