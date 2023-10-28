package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.models.MovieDetailDomain
import kotlinx.coroutines.flow.Flow

interface FetchAllSavedMoviesUseCase {
    operator fun invoke(): Flow<List<MovieDetailDomain>>
}