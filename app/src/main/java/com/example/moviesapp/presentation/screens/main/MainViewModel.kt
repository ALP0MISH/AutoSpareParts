package com.example.moviesapp.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.use_case.FetchMoviesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchMoviesInteractor: FetchMoviesInteractor,

    ) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<MainUIState>(MainUIState.Loading)
    val uiStateFlow: StateFlow<MainUIState> = _uiStateFlow.asStateFlow()
    init {
        fetchAllMovies()
    }
    fun fetchAllMovies() {
        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            _uiStateFlow.tryEmit(MainUIState.Error(throwable.localizedMessage ?: ""))
        }
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(MainUIState.Loading)
            val popularMovies = fetchMoviesInteractor.fetchPopularMovie()
            val upComingMovies = fetchMoviesInteractor.fetchUpcomingMovie()
            val topRatedMovies = fetchMoviesInteractor.fetchTopRatedMovie()
            val nowPlayingMovies = fetchMoviesInteractor.fetchNowPlayingMovie()
            Log.i("Abdurahman","result: ${nowPlayingMovies.size}")
            val loaded = MainUIState.Loaded(
                popularMovies = popularMovies,
                nowPlayingMovies = nowPlayingMovies,
                topRatedMovies = topRatedMovies,
                upComingMovies = upComingMovies
            )
            _uiStateFlow.tryEmit(loaded)
        }
    }
}