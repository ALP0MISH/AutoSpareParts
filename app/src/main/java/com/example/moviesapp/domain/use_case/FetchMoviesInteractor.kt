package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.models.MovieDomain

    interface FetchMoviesInteractor {

    suspend fun fetchPopularMovie(): List<MovieDomain>
    suspend fun fetchTopRatedMovie(): List<MovieDomain>
    suspend fun fetchUpcomingMovie(): List<MovieDomain>
    suspend fun fetchNowPlayingMovie(): List<MovieDomain>
}