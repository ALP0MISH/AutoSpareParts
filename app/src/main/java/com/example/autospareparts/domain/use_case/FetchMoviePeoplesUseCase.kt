package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.ActorsDomain
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