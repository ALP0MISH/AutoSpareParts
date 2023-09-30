package com.example.autospareparts.data.remote

import com.example.autospareparts.data.models.now_playing_remote.NowPlayingRemote
import com.example.autospareparts.data.models.popular_movie_remote.PopularMovieRemote
import com.example.autospareparts.data.models.top_rated_movie_remote.TopRatedMovieRemote
import com.example.autospareparts.data.models.upcoming_movie_remote.UpComingRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

const val POSTER_PATH_URL = "https://image.tmdb.org/t/p/w342"

private const val API_KEY =
    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkNTBjMTU5NWQxMDg5MWMzYTI0MGQ0MGQ1NzFjMWFjYiIsInN1YiI6IjY0ZjFkMzBkNWYyYjhkMDExYjRkNGU5MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.0RRqtA53mLHoTEoruckVumFZccd8_gWl4gsaZ5mjZDM"

interface MovieService {
    @GET("/3/movie/popular")
    suspend fun     fetchPopularMovie(
        @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<PopularMovieRemote>

    @GET("/3/movie/top_rated")
    suspend fun fetchTopRatedMovie(
        @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<TopRatedMovieRemote>

    @GET("/3/movie/upcoming")
    suspend fun fetchUpcomingMovie(
        @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<UpComingRemote>

    @GET("/3/movie/now_playing")
    suspend fun fetchNowPlayingMovie(
        @Header("Authorization") apiKey: String = "Bearer $API_KEY"
    ): Response<NowPlayingRemote>

}
