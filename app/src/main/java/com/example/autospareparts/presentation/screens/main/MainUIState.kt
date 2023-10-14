package com.example.autospareparts.presentation.screens.main

import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.presentation.models.MovieUi

sealed interface MainUIState {
    object Loading : MainUIState

    data class Loaded(
        val popularMovies: List<MovieDomain>,
        val upComingMovies: List<MovieDomain>,
        val topRatedMovies: List<MovieDomain>,
        val nowPlayingMovies: List<MovieDomain>,
    ) : MainUIState

    data class Error(
        val message: String
    ) : MainUIState
}