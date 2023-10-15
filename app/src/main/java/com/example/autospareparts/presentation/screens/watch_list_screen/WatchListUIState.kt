package com.example.autospareparts.presentation.screens.watch_list_screen

import com.example.autospareparts.domain.models.MovieDomain

sealed interface WatchListUIState {
    object Loading : WatchListUIState

    data class Loaded(
        val searchMovie: List<MovieDomain>,
    ) : WatchListUIState

    data class Error(
        val message: String
    ) : WatchListUIState
}