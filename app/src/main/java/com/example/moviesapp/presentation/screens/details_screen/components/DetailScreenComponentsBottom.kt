package com.example.moviesapp.presentation.screens.details_screen.components

import androidx.annotation.StringRes
import com.example.moviesapp.R
import com.example.moviesapp.domain.models.PeopleDomain
import com.example.moviesapp.domain.models.ReviewsDomain
import kotlinx.coroutines.flow.StateFlow

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