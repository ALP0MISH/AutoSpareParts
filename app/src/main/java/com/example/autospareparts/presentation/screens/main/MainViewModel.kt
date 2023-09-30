package com.example.autospareparts.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autospareparts.domain.use_case.FetchAllPopularMovies
import com.example.autospareparts.domain.use_case.FetchNowPlayingMovieUseCase
import com.example.autospareparts.domain.use_case.FetchTopRatedMovieUseCase
import com.example.autospareparts.domain.use_case.FetchUpComingMovieUseCase
import com.example.autospareparts.presentation.mappers.isUnknown
import com.example.autospareparts.presentation.mappers.toUi
import com.example.autospareparts.presentation.models.FetchType
import com.example.autospareparts.presentation.models.MovieUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class MainScreenUiState {
    object Loading : MainScreenUiState()

    data class Loaded(
        val movies: List<MovieUi>
    ) : MainScreenUiState()

    data class Error(
        val message: String
    ) : MainScreenUiState()
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchAllPopularMovies: FetchAllPopularMovies,
    private val fetchTopRatedMovieUseCase: FetchTopRatedMovieUseCase,
    private val fetchNowPlayingMovieUseCase: FetchNowPlayingMovieUseCase,
    private val fetchUpComingMovieUseCase: FetchUpComingMovieUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<MainScreenUiState>(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    init {
        getMovies(FetchType.POPULAR)
    }

    fun popularMovie() {
        getMovies(FetchType.POPULAR)
    }

    fun topRatedMovie() {
        getMovies(FetchType.TOP_RATED)
    }

    fun nowPlayingMovie() {
        getMovies(FetchType.NOW_PLAYING)
    }

    fun upComingMovie() {
        getMovies(FetchType.UP_COMING)
    }

    private fun getMovies(fetchType: FetchType) {
        _uiState.tryEmit(MainScreenUiState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val upComingMovies = when (fetchType) {
                FetchType.UP_COMING -> fetchUpComingMovieUseCase.invoke().toUi()
                FetchType.POPULAR -> fetchAllPopularMovies.invoke().toUi()
                FetchType.NOW_PLAYING -> fetchNowPlayingMovieUseCase.invoke().toUi()
                FetchType.TOP_RATED -> fetchTopRatedMovieUseCase.invoke().toUi()
            }
            if (upComingMovies.isUnknown()) {
                _uiState.tryEmit(MainScreenUiState.Error("Что то пошло не так "))
            } else {
                _uiState.tryEmit(
                    MainScreenUiState.Loaded(upComingMovies)
                )
            }
        }
    }
}