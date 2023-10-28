package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.MovieRepository
import com.example.moviesapp.domain.models.MovieDetailDomain
import javax.inject.Inject

class FetchMovieByIdUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : FetchMovieByIdUseCase {
    override suspend fun fetchMovieById(movieId: Int): MovieDetailDomain? {
        return repository.fetchMovieById(movieId)
    }
}