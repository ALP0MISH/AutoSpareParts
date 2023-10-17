package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDetailDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAllSavedMoviesUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : FetchAllSavedMoviesUseCase {
    override fun invoke(): Flow<List<MovieDetailDomain>> {
        return movieRepository.fetchAllSavedMovies()
    }
}