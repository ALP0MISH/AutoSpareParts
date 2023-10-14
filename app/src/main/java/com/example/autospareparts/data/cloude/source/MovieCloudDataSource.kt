package com.example.autospareparts.data.cloude.source

import com.example.autospareparts.data.cloude.models.all_movies_remote.MovieRemote
import com.example.autospareparts.data.cloude.models.all_movies_remote.MovieResult
import com.example.autospareparts.data.cloude.models.detail_remote.DetailResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieCloudDataSource {
    suspend fun fetchPopularMovie(): List<MovieResult>

    suspend fun fetchTopRatedMovie(): List<MovieResult>

    suspend fun fetchUpcomingMovie(): List<MovieResult>

    suspend fun fetchNowPlayingMovie(): List<MovieResult>

    suspend fun fetchSearchMovie(query: String): List<MovieResult>

    suspend fun fetchMovieById(movieId: Int): DetailResult?
}