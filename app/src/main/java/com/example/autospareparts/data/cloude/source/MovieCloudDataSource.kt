package com.example.autospareparts.data.cloude.source

import com.example.autospareparts.data.cloude.models.all_movies_remote.MovieResult
import com.example.autospareparts.data.cloude.models.credits_remote.ActorsResponse
import com.example.autospareparts.data.cloude.models.detail_remote.DetailResult
import com.example.autospareparts.data.cloude.models.reviews_remote.ReviewsCloud
import com.example.autospareparts.data.cloude.models.reviews_remote.ReviewsResponse
import kotlinx.coroutines.flow.StateFlow

interface MovieCloudDataSource {
    suspend fun fetchPopularMovie(): List<MovieResult>
    suspend fun fetchTopRatedMovie(): List<MovieResult>
    suspend fun fetchUpcomingMovie(): List<MovieResult>
    suspend fun fetchNowPlayingMovie(): List<MovieResult>
    suspend fun fetchSearchMovie(query: String): List<MovieResult>
    suspend fun fetchMovieById(movieId: Int): DetailResult?
    suspend fun fetchMoviePeoples(movieId: Int): ActorsResponse
    suspend fun fetchMovieReviews(movieId: Int): List<ReviewsCloud>
}