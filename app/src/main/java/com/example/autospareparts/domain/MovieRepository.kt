package com.example.autospareparts.domain

import com.example.autospareparts.data.cashe.models.MovieDetailCache
import com.example.autospareparts.data.cloude.models.all_movies_remote.MovieResult
import com.example.autospareparts.data.cloude.models.detail_remote.DetailResult
import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.domain.models.MovieDetailDomain
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun addNewMovie(movie: MovieDetailDomain)
    suspend fun deleteMovieById(movieId: Int)
    suspend fun fetchSavedMovies(): List<MovieDetailDomain>
    suspend fun fetchPopularMovie(): List<MovieDomain>
    suspend fun fetchTopRatedMovie(): List<MovieDomain>
    suspend fun fetchUpcomingMovie(): List<MovieDomain>
    suspend fun fetchNowPlayingMovie(): List<MovieDomain>
    suspend fun fetchSearchMovie(query: String): List<MovieDomain>
    suspend fun fetchMovieById(movieId: Int): MovieDetailDomain?
     fun isMovieSavedFlow(movieId: Int): Flow<Boolean>

}