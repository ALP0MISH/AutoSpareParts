package com.example.moviesapp.domain.use_case

import kotlinx.coroutines.flow.Flow

interface IsMovieSavedUseCase {
    operator fun invoke(movieId: Int): Flow<Boolean>
}