package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDetailDomain
import javax.inject.Inject

class FetchMovieByIdUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : FetchMovieByIdUseCase {
    override suspend fun fetchMovieById(movieId: Int): MovieDetailDomain? {
        return repository.fetchMovieById(movieId)
    }
}