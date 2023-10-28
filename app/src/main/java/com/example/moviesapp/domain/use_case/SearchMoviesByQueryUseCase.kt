package com.example.moviesapp.domain.use_case

import com.example.moviesapp.domain.models.MovieDomain

interface SearchMoviesByQueryUseCase {
    suspend fun fetchSearchMovie(query: String): List<MovieDomain>
}