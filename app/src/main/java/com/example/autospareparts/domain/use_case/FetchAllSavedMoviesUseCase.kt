package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.models.MovieDetailDomain
import com.example.autospareparts.domain.models.MovieDomain
import kotlinx.coroutines.flow.Flow

interface FetchAllSavedMoviesUseCase {
    operator fun invoke(): Flow<List<MovieDetailDomain>>
}