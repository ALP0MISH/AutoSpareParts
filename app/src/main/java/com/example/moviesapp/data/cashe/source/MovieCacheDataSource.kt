package com.example.moviesapp.data.cashe.source

import com.example.moviesapp.data.cashe.models.MovieDetailCache
import kotlinx.coroutines.flow.Flow

interface MovieCacheDataSource {
    suspend fun addNewMovie(movie: MovieDetailCache)
    suspend fun deleteMovieById(movieId: Int)
    fun fetchSavedMovies(): Flow<List<MovieDetailCache>>
     fun isMovieSavedFloe(movieId: Int): Flow<Boolean>
}