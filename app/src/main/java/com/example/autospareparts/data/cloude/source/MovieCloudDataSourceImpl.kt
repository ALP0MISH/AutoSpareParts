package com.example.autospareparts.data.cloude.source

import com.example.autospareparts.data.cloude.MovieService
import com.example.autospareparts.data.cloude.models.all_movies_remote.MovieResult
import com.example.autospareparts.data.cloude.models.credits_remote.ActorsResponse
import com.example.autospareparts.data.cloude.models.detail_remote.DetailResult
import com.example.autospareparts.data.cloude.models.reviews_remote.ReviewsCloud
import com.example.autospareparts.data.cloude.models.reviews_remote.ReviewsResponse
import kotlinx.coroutines.flow.StateFlow

class MovieCloudDataSourceImpl(
    private val movieService: MovieService
) : MovieCloudDataSource {
    override suspend fun fetchPopularMovie(): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchPopularMovie()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override suspend fun fetchTopRatedMovie(): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchTopRatedMovie()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override suspend fun fetchUpcomingMovie(): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchUpcomingMovie()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override suspend fun fetchNowPlayingMovie(): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchNowPlayingMovie()
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override suspend fun fetchSearchMovie(query: String): List<MovieResult> {
        return try {
            val movieResponse = movieService.fetchSearchMovie(query)
            if (movieResponse.isSuccessful) {
                movieResponse.body()?.results ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override suspend fun fetchMovieById(movieId: Int): DetailResult? {
        return try {
            val movieResponse = movieService.fetchMovieById(movieId)
            if (movieResponse.isSuccessful) {
                movieResponse.body()
            } else {
                null
            }
        } catch (e: Throwable) {
            null
        }
    }


    override suspend fun fetchMoviePeoples(movieId: Int): ActorsResponse {
        return try {
            val response = movieService.fetchMovieActors(movieId)
            if (response.isSuccessful && response.body() != null) {
                response.body()!!
            } else ActorsResponse.unknown
        } catch (e: Exception) {
            ActorsResponse.unknown
        }
    }

    override suspend fun fetchMovieReviews(movieId: Int): List<ReviewsCloud> {
        return try {
            val response = movieService.fetchMovieReviews(movieId)
            if (response.isSuccessful && response.body() != null) {
                response.body()!!.reviewsClouds
            } else emptyList()
        } catch (e: Throwable) {
            emptyList()
        }
    }
}