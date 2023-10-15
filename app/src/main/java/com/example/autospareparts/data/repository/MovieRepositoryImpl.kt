package com.example.autospareparts.data.repository

import com.example.autospareparts.data.cashe.source.MovieCacheDataSource
import com.example.autospareparts.data.cloude.source.MovieCloudDataSource
import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDetailDomain
import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.presentation.mappers.toCache
import com.example.autospareparts.presentation.mappers.toUi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val cloudDataSource: MovieCloudDataSource,
    private val cacheDataSource: MovieCacheDataSource
) :
    MovieRepository {

    override suspend fun addNewMovie(movie: MovieDetailDomain) {
        cacheDataSource.addNewMovie(movie = movie.toCache())
    }

    override suspend fun deleteMovieById(movieId: Int) {
        cacheDataSource.deleteMovieById(movieId)
    }

    override suspend fun fetchSavedMovies(): List<MovieDetailDomain> {
        return cacheDataSource.fetchSavedMovies().map { it.toUi() }
    }

    override suspend fun fetchPopularMovie(): List<MovieDomain> {
        return cloudDataSource.fetchPopularMovie().map { it.toUi() }
    }

    override suspend fun fetchTopRatedMovie(): List<MovieDomain> {
        return cloudDataSource.fetchTopRatedMovie().map { it.toUi() }
    }

    override suspend fun fetchUpcomingMovie(): List<MovieDomain> {
        return cloudDataSource.fetchUpcomingMovie().map { it.toUi() }
    }

    override suspend fun fetchNowPlayingMovie(): List<MovieDomain> {
        return cloudDataSource.fetchNowPlayingMovie().map { it.toUi() }
    }

    override suspend fun fetchSearchMovie(query: String): List<MovieDomain> {
        return cloudDataSource.fetchSearchMovie(query).map { it.toUi() }
    }

    override suspend fun fetchMovieById(movieId: Int): MovieDetailDomain? {
        return cloudDataSource.fetchMovieById(movieId)?.toUi()
    }

    override fun isMovieSavedFlow(movieId: Int): Flow<Boolean> {
        return cacheDataSource.isMovieSavedFloe(movieId)
    }
}