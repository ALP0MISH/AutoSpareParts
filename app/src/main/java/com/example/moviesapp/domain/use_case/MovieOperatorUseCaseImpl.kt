package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.MovieRepository
import com.example.moviesapp.domain.models.MovieDetailDomain
import javax.inject.Inject

class MovieOperatorUseCaseImpl  @Inject constructor(
    private val repository: MovieRepository
): MovieOperatorUseCase{
    override suspend fun saveMovie(movie: MovieDetailDomain) {
        repository.addNewMovie(movie)
    }

    override suspend fun deleteMovieById(movie: Int) {
        repository.deleteMovieById(movie)
    }
}