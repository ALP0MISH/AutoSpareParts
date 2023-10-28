package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.models.MovieDetailDomain

interface FetchMovieByIdUseCase {
    suspend fun fetchMovieById(movieId: Int): MovieDetailDomain?

}