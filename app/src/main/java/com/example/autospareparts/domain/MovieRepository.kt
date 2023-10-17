package com.example.autospareparts.domain

import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.domain.models.MovieDetailDomain
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

}