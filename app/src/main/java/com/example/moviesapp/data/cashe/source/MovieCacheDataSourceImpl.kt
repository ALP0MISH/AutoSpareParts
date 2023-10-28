package com.example.moviesapp.data.cashe.source

import com.example.moviesapp.data.cashe.dao.MovieDao
import com.example.moviesapp.data.cashe.models.MovieDetailCache
import kotlinx.coroutines.flow.Flow

class MovieCacheDataSourceImpl(
    private val movieDao: MovieDao
): MovieCacheDataSource {
    override suspend fun addNewMovie(movie: MovieDetailCache) {
        movieDao.addNewMovie(movie)
    }
    override suspend fun deleteMovieById(movieId: Int) {
        movieDao.deleteMovieById(movieId)
    }
    override fun fetchSavedMovies(): Flow<List<MovieDetailCache>> {
       return movieDao.fetchSavedMovies()
    }
     override fun isMovieSavedFloe(movieId: Int): Flow<Boolean> {
        return movieDao.isMovieSave(movieId)
    }
}