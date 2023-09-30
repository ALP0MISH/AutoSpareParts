package com.example.autospareparts.domain.use_case

import com.example.autospareparts.domain.models.MovieDomain

interface FetchAllPopularMovies {
    suspend operator fun invoke(): List<MovieDomain>
}