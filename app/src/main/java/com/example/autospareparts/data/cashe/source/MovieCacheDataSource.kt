package com.example.autospareparts.data.cashe.source

import com.example.autospareparts.data.cashe.models.MovieDetailCache

interface MovieCacheDataSource {
    suspend fun addNewMovie(movie: MovieDetailCache)

    suspend fun deleteMovieById(movieId: String)

    suspend fun fetchSavedMovies(): List<MovieDetailCache>
}