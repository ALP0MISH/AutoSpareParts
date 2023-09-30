package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDomain

class FetchTopRatedMovieUseCaseImpl(
    private val repository: MovieRepository
): FetchTopRatedMovieUseCase {
    override suspend fun invoke(): List<MovieDomain> {
        return repository.fetchTopRatedMovie()
    }

}