package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.MovieRepository
import com.example.autospareparts.domain.models.MovieDomain

class FetchNowPlayingMovieUseCaseImpl(
    private val repository: MovieRepository
): FetchNowPlayingMovieUseCase {
    override suspend fun invoke(): List<MovieDomain> {
        return repository.fetchNowPlayingMovie()
    }

}