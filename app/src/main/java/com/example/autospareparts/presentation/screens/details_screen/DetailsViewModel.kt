package com.example.autospareparts.presentation.screens.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autospareparts.domain.use_case.FetchMovieByIdUseCase
import com.example.autospareparts.domain.use_case.IsMovieSavedUseCase
import com.example.autospareparts.domain.use_case.MovieOperatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val fetchMovieByIdUseCase: FetchMovieByIdUseCase,
    private val isMovieSavedUseCase: IsMovieSavedUseCase,
    private val movieOperatorUseCase: MovieOperatorUseCase,


    ) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<DetailScreenUiState>(DetailScreenUiState.Loading)
    val uiStateFlow: StateFlow<DetailScreenUiState> = _uiStateFlow.asStateFlow()


    fun fetchMovieByID(id: Int) {
        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            _uiStateFlow.tryEmit(DetailScreenUiState.Error(throwable.localizedMessage ?: ""))
        }
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(DetailScreenUiState.Loading)
            val movieDetail = fetchMovieByIdUseCase.fetchMovieById(id)

            if (movieDetail == null) {
                _uiStateFlow.tryEmit(DetailScreenUiState.Error("Something is wrong"))
            } else {
                _uiStateFlow.tryEmit(DetailScreenUiState.Loaded(movieDetail))
                checkISMovieSave(id)
            }
        }
    }


    fun addOrDeleteMovie(movieId: Int) {
        val uiState = _uiStateFlow.value as? DetailScreenUiState.Loaded ?: return
        viewModelScope.launch(Dispatchers.IO) {
            if (uiState.isSaved) {
                movieOperatorUseCase.deleteMovieById(movieId)
                checkISMovieSave(movieId)
            } else {
                movieOperatorUseCase.saveMovie(uiState.movies)
                checkISMovieSave(movieId)
            }
        }
    }

    private fun checkISMovieSave(movieId: Int) {
        isMovieSavedUseCase.invoke(movieId)
            .onEach { isSaved: Boolean ->
                val uiState = _uiStateFlow.value as? DetailScreenUiState.Loaded ?: return@onEach
                _uiStateFlow.tryEmit(uiState.copy(isSaved = isSaved))
            }
            .launchIn(viewModelScope)
    }
}