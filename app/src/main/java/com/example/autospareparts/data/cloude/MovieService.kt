package com.example.autospareparts.data.cloude

import com.example.autospareparts.data.cloude.models.all_movies_remote.MovieRemote
import com.example.autospareparts.data.cloude.models.detail_remote.DetailResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


private const val API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNTBjMTU5NWQxMDg5MWMzYTI0MGQ0MGQ1NzFjMWFjYiIsInN1YiI6IjY0ZjFkMzBkNWYyYjhkMDExYjRkNGU5MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.0RRqtA53mLHoTEoruckVumFZccd8_gWl4gsaZ5mjZDM"

interface MovieService {
    @GET("/3/movie/popular")
    suspend fun fetchPopularMovie(
      //  @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<MovieRemote>

    @GET("/3/movie/top_rated")
    suspend fun fetchTopRatedMovie(
       // @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<MovieRemote>

    @GET("/3/movie/upcoming")
    suspend fun fetchUpcomingMovie(
      //  @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<MovieRemote>

    @GET("/3/movie/now_playing")
    suspend fun fetchNowPlayingMovie(
      //  @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<MovieRemote>

    @GET("/3/movie/search/movie")
    suspend fun fetchSearchMovie(
        @Query("query") query: String,
       // @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<MovieRemote>

    @GET("/3/movie/{movie_id}")
    suspend fun fetchMovieById(
        @Path("movie_id") movieId: Int,
      //  @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<DetailResult>
}