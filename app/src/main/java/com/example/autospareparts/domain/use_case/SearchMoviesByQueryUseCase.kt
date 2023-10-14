package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.models.MovieDomain

interface SearchMoviesByQueryUseCase {
    suspend fun fetchSearchMovie(query: String): List<MovieDomain>

}