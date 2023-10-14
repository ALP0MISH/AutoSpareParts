package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.models.MovieDetailDomain

interface FetchMovieByIdUseCase {
    suspend fun fetchMovieById(movieId: Int): MovieDetailDomain?

}