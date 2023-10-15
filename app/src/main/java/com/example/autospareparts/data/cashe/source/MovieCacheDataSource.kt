package com.example.autospareparts.data.cashe.source

import com.example.autospareparts.data.cashe.models.MovieDetailCache
import kotlinx.coroutines.flow.Flow

interface MovieCacheDataSource {
    suspend fun addNewMovie(movie: MovieDetailCache)

    suspend fun deleteMovieById(movieId: Int)

    suspend fun fetchSavedMovies(): List<MovieDetailCache>

     fun isMovieSavedFloe(movieId: Int): Flow<Boolean>
}