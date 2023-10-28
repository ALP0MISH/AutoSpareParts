package com.example.moviesapp.domain.models

data class MovieDetailDomain(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val movieGenresName: List<String>,
    val homepage: String,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val runtime: Int,
    val voteAverage: Double,
    val voteCount: Int
)