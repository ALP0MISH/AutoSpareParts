package com.example.autospareparts.presentation.models

import com.example.autospareparts.data.cloude.models.detail_remote.MovieGenre

data class DetailUi(
    val adult: Boolean,
    val backdropPath: String,
    val budget: Int,
    val movieGenres: List<MovieGenre>,
    val homepage: String,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val runtime: Int,
    val status: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int,
) {
    fun isUnknown() = this == unknown
    companion object {
        val unknown = DetailUi(
            adult = false,
            backdropPath = "",
            budget = 0,
            movieGenres = listOf(),
            homepage = "",
            id = 0,
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            releaseDate = "",
            runtime = 0,
            status = "",
            title = "",
            voteAverage = 0.0,
            voteCount = 0,
            posterPath = ""
        )
    }
}