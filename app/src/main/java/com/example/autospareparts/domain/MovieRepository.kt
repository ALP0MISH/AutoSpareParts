package com.example.autospareparts.domain
import com.example.autospareparts.domain.models.MovieDomain

interface MovieRepository {
    suspend fun fetchPopularMovie(): List<MovieDomain>
    suspend fun fetchTopRatedMovie(): List<MovieDomain>
    suspend fun fetchNowPlayingMovie(): List<MovieDomain>
    suspend fun fetchUpComingMovie(): List<MovieDomain>
}