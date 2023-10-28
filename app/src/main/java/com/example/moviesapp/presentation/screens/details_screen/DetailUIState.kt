package com.example.moviesapp.presentation.screens.details_screen

import com.example.moviesapp.domain.models.MovieDetailDomain
import com.example.moviesapp.presentation.screens.details_screen.components.DetailTabBar

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