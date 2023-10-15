package com.example.autospareparts.data.cloude.source

import android.util.Log
import com.example.autospareparts.data.cloude.MovieService
import com.example.autospareparts.data.cloude.models.all_movies_remote.MovieResult
import com.example.autospareparts.data.cloude.models.detail_remote.DetailResult

class MovieCloudDataSourceImpl(
    private val movieService: MovieService
) : MovieCloudDataSource {
    override suspend fun fetchPopularMovie(): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchPopularMovie()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else { emptyList() }
        } catch (e: Throwable) { emptyList() }
    }

    override suspend fun fetchTopRatedMovie(): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchTopRatedMovie()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else { emptyList() }
        } catch (e: Throwable) { emptyList() }
    }

    override suspend fun fetchUpcomingMovie(): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchUpcomingMovie()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else { emptyList() }
        } catch (e: Throwable) { emptyList() }
    }

    override suspend fun fetchNowPlayingMovie(): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchNowPlayingMovie()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else { emptyList() }
        } catch (e: Throwable) { emptyList() }
    }

    override suspend fun fetchSearchMovie(query: String): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchSearchMovie(query)
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else { emptyList()}
        } catch (e: Throwable) {
            emptyList() }
    }

    override suspend fun fetchMovieById(movieId: Int): DetailResult? {
        return try {
            val movieResponse = movieService.fetchMovieById(movieId)
            if (movieResponse.isSuccessful) {
                movieResponse.body()
            } else { null }
        } catch (e: Throwable) { null }
    }
}

