package com.example.autospareparts.presentation.screens.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autospareparts.domain.models.MovieDetailDomain
import com.example.autospareparts.domain.use_case.FetchMovieByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val fetchMovieByIdUseCase: FetchMovieByIdUseCase,

    ) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<DetailScreenUiState>(DetailScreenUiState.Loading)
    val uiStateFlow: StateFlow<DetailScreenUiState> = _uiStateFlow.asStateFlow()

    fun fetchMovieByID(id : Int) {
        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            _uiStateFlow.tryEmit(DetailScreenUiState.Error(throwable.localizedMessage ?: ""))
        }
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(DetailScreenUiState.Loading)
            val movieDetail = fetchMovieByIdUseCase.fetchMovieById(id)

            if (movieDetail == null) {
                _uiStateFlow.tryEmit(DetailScreenUiState.Error("Something is wrong"))

            }else {
                _uiStateFlow.tryEmit(DetailScreenUiState.Loaded(movieDetail))
            }
        }
    }
}