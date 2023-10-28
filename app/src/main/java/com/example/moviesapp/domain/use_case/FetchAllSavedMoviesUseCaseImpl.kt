package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.MovieRepository
import com.example.moviesapp.domain.models.MovieDetailDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAllSavedMoviesUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : FetchAllSavedMoviesUseCase {
    override fun invoke(): Flow<List<MovieDetailDomain>> {
        return movieRepository.fetchAllSavedMovies()
    }
}