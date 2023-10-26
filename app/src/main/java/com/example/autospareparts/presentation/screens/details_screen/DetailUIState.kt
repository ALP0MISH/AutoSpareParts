package com.example.autospareparts.presentation.screens.details_screen

import com.example.autospareparts.domain.models.ActorsDomain
import com.example.autospareparts.domain.models.MovieDetailDomain
import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.presentation.models.MovieUi
import com.example.autospareparts.presentation.screens.details_screen.components.DetailTabBar

sealed class DetailScreenUiState {
    object Loading : DetailScreenUiState()
    data class Loaded(
        val movies: MovieDetailDomain,
        val tabs: List<DetailTabBar>,
        val isSaved: Boolean = false
    ) : DetailScreenUiState()

    data class Error(
        val message: String
    ) : DetailScreenUiState()
}