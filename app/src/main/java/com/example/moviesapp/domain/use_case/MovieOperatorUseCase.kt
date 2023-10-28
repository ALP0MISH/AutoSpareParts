package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.models.MovieDetailDomain

interface MovieOperatorUseCase {
    suspend fun saveMovie(movie: MovieDetailDomain)
    suspend fun deleteMovieById(movie: Int)
}