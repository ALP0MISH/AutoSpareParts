package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.MovieRepository
import com.example.moviesapp.domain.models.ReviewsDomain
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