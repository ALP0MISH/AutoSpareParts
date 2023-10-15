package com.example.autospareparts.data.cloude

import com.example.autospareparts.data.cloude.models.all_movies_remote.MovieRemote
import com.example.autospareparts.data.cloude.models.detail_remote.DetailResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query



interface MovieService {
    @GET("/3/movie/popular")
    suspend fun fetchPopularMovie(
    ): Response<MovieRemote>

    @GET("/3/movie/top_rated")
    suspend fun fetchTopRatedMovie(
    ): Response<MovieRemote>

    @GET("/3/movie/upcoming")
    suspend fun fetchUpcomingMovie(
    ): Response<MovieRemote>

    @GET("/3/movie/now_playing")
    suspend fun fetchNowPlayingMovie(
    ): Response<MovieRemote>

    @GET("/3/search/movie")
    suspend fun fetchSearchMovie(
        @Query("query") query: String,

    ): Response<MovieRemote>

    @GET("/3/movie/{movie_id}")
    suspend fun fetchMovieById(
        @Path("movie_id") movieId: Int,
    ): Response<DetailResult>
}