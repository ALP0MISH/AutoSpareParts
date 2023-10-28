package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.MovieRepository
import com.example.moviesapp.domain.models.ActorsDomain
import javax.inject.Inject

interface FetchMoviePeoplesUseCase {
    suspend operator fun invoke(movieId: Int): ActorsDomain
}
class FetchMoviePeoplesUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : FetchMoviePeoplesUseCase{
    override suspend fun invoke(movieId: Int): ActorsDomain {
        return movieRepository.fetchMoviePeoples(movieId)
    }
}