package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.MovieRepository
import com.example.moviesapp.domain.models.MovieDomain
import javax.inject.Inject

class SearchMoviesByQueryUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : SearchMoviesByQueryUseCase {
    override suspend fun fetchSearchMovie(query: String): List<MovieDomain> {
        return repository.fetchSearchMovie(query)
    }
}