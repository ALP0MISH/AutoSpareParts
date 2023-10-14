package com.example.autospareparts.data.cashe.source

import com.example.autospareparts.data.cashe.dao.MovieDao
import com.example.autospareparts.data.cashe.models.MovieDetailCache

class MovieCacheDataSourceImpl(
    private val movieDao: MovieDao
): MovieCacheDataSource {
    override suspend fun addNewMovie(movie: MovieDetailCache) {
        movieDao.addNewMovie(movie)
    }

    override suspend fun deleteMovieById(movieId: String) {
        movieDao.deleteMovieById(movieId)
    }

    override suspend fun fetchSavedMovies(): List<MovieDetailCache> {
       return movieDao.fetchSavedMovies()
    }
}