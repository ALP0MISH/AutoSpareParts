package com.example.moviesapp.presentation.screens.watch_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.models.MovieDetailDomain
import com.example.moviesapp.domain.use_case.FetchAllSavedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

data class WatchListUIState(
    val movies: List<MovieDetailDomain> = emptyList()
)

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val fetchAllSavedMoviesUseCase: FetchAllSavedMoviesUseCase
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow(WatchListUIState())
    val uiStateFlow: StateFlow<WatchListUIState> = _uiStateFlow.asStateFlow()

    fun fetchAllSavedMovies() {
        fetchAllSavedMoviesUseCase()
            .onEach { movies ->
                _uiStateFlow.tryEmit(WatchListUIState(movies = movies))
            }.launchIn(viewModelScope)
    }
}