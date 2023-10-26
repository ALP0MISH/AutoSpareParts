package com.example.autospareparts.presentation.screens.details_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autospareparts.domain.models.ActorsDomain
import com.example.autospareparts.domain.models.ReviewsDomain
import com.example.autospareparts.domain.use_case.FetchMovieByIdUseCase
import com.example.autospareparts.domain.use_case.FetchMoviePeoplesUseCase
import com.example.autospareparts.domain.use_case.FetchMovieReviewsUseCase
import com.example.autospareparts.domain.use_case.IsMovieSavedUseCase
import com.example.autospareparts.domain.use_case.MovieOperatorUseCase
import com.example.autospareparts.presentation.screens.details_screen.components.DetailTabBar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val fetchMovieByIdUseCase: FetchMovieByIdUseCase,
    private val isMovieSavedUseCase: IsMovieSavedUseCase,
    private val movieOperatorUseCase: MovieOperatorUseCase,
    private val fetchMoviePeoplesUseCase: FetchMoviePeoplesUseCase,
    private val fetchMovieReviewsUseCase: FetchMovieReviewsUseCase
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<DetailScreenUiState>(DetailScreenUiState.Loading)
    val uiStateFlow: StateFlow<DetailScreenUiState> = _uiStateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        _uiStateFlow.tryEmit(DetailScreenUiState.Error(throwable.localizedMessage ?: ""))
    }

    private val sortByFlow = MutableStateFlow(SortByItems.BY_RATING)
    private val reviewFlow = MutableStateFlow<List<ReviewsDomain>>(emptyList())

    init {
        sortByFlow.combine(reviewFlow) { sortBy, review ->
            when (sortBy){
                SortByItems.BY_RATING -> review.sortedByDescending { it.reviewsDetails.rating }
                SortByItems.BY_RATING_DOWN -> review.sortedBy { it.reviewsDetails.rating }
                SortByItems.BY_ADDED -> review.sortedByDescending { it.created_at }
                SortByItems.BY_ADDED_DOWN -> review.sortedBy { it.created_at }
            }
        }.onEach { reviews ->
            reviewFlow.tryEmit(reviews)
        }.launchIn(viewModelScope)
    }

    fun onFilterClick(sortBy: SortByItems) {
        sortByFlow.tryEmit(sortBy)
    }

    fun init(movieId: Int) {
        fetchMovieByID(movieId)
    }

    private fun fetchMovieByID(id: Int) {
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(DetailScreenUiState.Loading)
            val movieDetail = fetchMovieByIdUseCase.fetchMovieById(id)
            val actorDomain = fetchMoviePeoplesUseCase(id)
            val reviews = fetchMovieReviewsUseCase(id)
            reviewFlow.tryEmit(reviews)
            if (movieDetail == null) {
                _uiStateFlow.tryEmit(DetailScreenUiState.Error("Something is wrong"))
            } else {
                _uiStateFlow.tryEmit(
                    DetailScreenUiState.Loaded(
                        movies = movieDetail,
                        tabs = createTabsByParams(
                            aboutMovie = movieDetail.overview,
                            actorDomain = actorDomain,
                        ),
                    )
                )
                checkISMovieSave(id)
            }
        }
    }

    private fun createTabsByParams(
        aboutMovie: String,
        actorDomain: ActorsDomain,
    ): List<DetailTabBar> = listOf(
        DetailTabBar.AboutMovie(aboutMovie),
        DetailTabBar.Reviewers(reviewFlow),
        DetailTabBar.Casts(actorDomain.poepleCloude),
        DetailTabBar.Crews(actorDomain.crewCloud),
    )

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