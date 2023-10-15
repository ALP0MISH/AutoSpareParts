package com.example.autospareparts.domain.use_case

import kotlinx.coroutines.flow.Flow

interface IsMovieSavedUseCase {
    operator fun invoke(movieId: Int): Flow<Boolean>
}