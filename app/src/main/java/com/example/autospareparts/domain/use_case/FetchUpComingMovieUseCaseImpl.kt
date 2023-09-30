package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDomain

class FetchUpComingMovieUseCaseImpl(
    private val repository: MovieRepository
): FetchUpComingMovieUseCase {
    override suspend fun invoke(): List<MovieDomain> {
        return repository.fetchUpComingMovie()
    }

}