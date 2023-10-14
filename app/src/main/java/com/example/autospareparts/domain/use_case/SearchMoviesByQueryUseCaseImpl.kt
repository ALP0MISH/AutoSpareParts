package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDomain
import javax.inject.Inject

class SearchMoviesByQueryUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : SearchMoviesByQueryUseCase {
    override suspend fun fetchSearchMovie(query: String): List<MovieDomain> {
        return repository.fetchSearchMovie(query)
    }
}