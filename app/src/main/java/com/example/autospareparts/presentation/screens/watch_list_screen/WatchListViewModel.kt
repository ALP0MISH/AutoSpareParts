package com.example.autospareparts.presentation.screens.watch_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autospareparts.domain.use_case.SearchMoviesByQueryUseCase
import com.example.autospareparts.presentation.screens.details_screen.DetailScreenUiState
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
class WatchListViewModel @Inject constructor(
    private val searchMoviesByQueryUseCase: SearchMoviesByQueryUseCase,

    ) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<WatchListUIState>(WatchListUIState.Loading)
    val uiStateFlow: StateFlow<WatchListUIState> = _uiStateFlow.asStateFlow()


    fun searchMovieById(query: String) {
        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            _uiStateFlow.tryEmit(WatchListUIState.Error(throwable.localizedMessage ?: ""))
        }
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(WatchListUIState.Loading)
            val watchListDetail = searchMoviesByQueryUseCase.fetchSearchMovie(query)

            if (watchListDetail == null) {
                _uiStateFlow.tryEmit(WatchListUIState.Error("Something is wrong"))
            } else {
                _uiStateFlow.tryEmit(WatchListUIState.Loaded(watchListDetail))
            }
        }
    }
}