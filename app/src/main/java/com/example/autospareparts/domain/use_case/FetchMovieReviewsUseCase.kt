package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.ReviewsDomain
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

interface FetchMovieReviewsUseCase {
    suspend operator fun invoke(movieId : Int): List<ReviewsDomain>
}
class FetchMovieReviewsUseCaseImpl @Inject constructor(
    private val repository: MovieRepository,
): FetchMovieReviewsUseCase{
    override suspend fun invoke(movieId: Int): List<ReviewsDomain> {
        return repository.fetchMovieReviews(movieId)
    }
}