package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.models.MovieDetailDomain

interface MovieOperatorUseCase {
    suspend fun saveMovie(movie: MovieDetailDomain)
    suspend fun deleteMovieById(movie: Int)
}