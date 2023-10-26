package com.example.autospareparts.domain

import com.example.autospareparts.data.cloude.models.reviews_remote.ReviewsResponse
import com.example.autospareparts.domain.models.ActorsDomain
import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.domain.models.MovieDetailDomain
import com.example.autospareparts.domain.models.ReviewsDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MovieRepository {
    suspend fun addNewMovie(movie: MovieDetailDomain)
    suspend fun deleteMovieById(movieId: Int)
    fun fetchAllSavedMovies(): Flow<List<MovieDetailDomain>>
    suspend fun fetchPopularMovie(): List<MovieDomain>
    suspend fun fetchTopRatedMovie(): List<MovieDomain>
    suspend fun fetchUpcomingMovie(): List<MovieDomain>
    suspend fun fetchNowPlayingMovie(): List<MovieDomain>
    suspend fun fetchSearchMovie(query: String): List<MovieDomain>
    suspend fun fetchMovieById(movieId: Int): MovieDetailDomain?
    fun isMovieSavedFlow(movieId: Int): Flow<Boolean>
    suspend fun fetchMoviePeoples(movieId: Int): ActorsDomain
    suspend fun fetchMovieReviews(movieId: Int): List<ReviewsDomain>
}