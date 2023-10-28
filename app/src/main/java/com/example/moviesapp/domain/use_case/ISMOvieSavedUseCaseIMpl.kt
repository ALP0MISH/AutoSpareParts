package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsMovieSavedUseCaseIMpl@Inject constructor(
    private val repository: MovieRepository
): IsMovieSavedUseCase {
    override fun invoke(movieId: Int): Flow<Boolean> {
        return repository.isMovieSavedFlow(movieId)
    }
}