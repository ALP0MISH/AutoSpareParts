package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.domain.MovieRepository
import javax.inject.Inject

class FetchAllPopularMoviesImpl(
    private val repository: MovieRepository
) : FetchAllPopularMovies {

    override suspend fun invoke(): List<MovieDomain> {
        return repository.fetchPopularMovie()
    }
}