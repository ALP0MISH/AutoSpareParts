package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.models.MovieDomain

    interface FetchMoviesInteractor {

    suspend fun fetchPopularMovie(): List<MovieDomain>
    suspend fun fetchTopRatedMovie(): List<MovieDomain>
    suspend fun fetchUpcomingMovie(): List<MovieDomain>
    suspend fun fetchNowPlayingMovie(): List<MovieDomain>
}