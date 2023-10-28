package com.example.moviesapp.domain

import com.example.moviesapp.domain.models.ActorsDomain
import com.example.moviesapp.domain.models.MovieDomain
import com.example.moviesapp.domain.models.MovieDetailDomain
import com.example.moviesapp.domain.models.ReviewsDomain
import kotlinx.coroutines.flow.Flow

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