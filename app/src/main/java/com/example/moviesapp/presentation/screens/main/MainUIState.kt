package com.example.moviesapp.presentation.screens.main

import com.example.moviesapp.domain.models.MovieDomain

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