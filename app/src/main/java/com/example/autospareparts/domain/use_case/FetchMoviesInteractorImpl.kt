package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDomain
import javax.inject.Inject

class FetchMoviesInteractorImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : FetchMoviesInteractor {
    override suspend fun fetchPopularMovie(): List<MovieDomain> {
        return movieRepository.fetchPopularMovie()
    }

    override suspend fun fetchTopRatedMovie(): List<MovieDomain> {
        return movieRepository.fetchTopRatedMovie()
    }

    override suspend fun fetchUpcomingMovie(): List<MovieDomain> {
        return movieRepository.fetchUpcomingMovie()
    }

    override suspend fun fetchNowPlayingMovie(): List<MovieDomain> {
        return movieRepository.fetchNowPlayingMovie()
    }
}