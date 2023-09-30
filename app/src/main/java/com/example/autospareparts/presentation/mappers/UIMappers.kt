package com.example.autospareparts.presentation.mappers

import com.example.autospareparts.domain.models.MovieDomain
import com.example.autospareparts.presentation.models.MovieUi

fun List<MovieDomain>.toUi(): List<MovieUi> {
    return this.map { movieDomain ->
        MovieUi(
            backdropPath = movieDomain.backdropPath,
            genreIds = movieDomain.genreIds,
            id = movieDomain.id,
            originalLanguage = movieDomain.originalLanguage,
            overview = movieDomain.overview,
            popularity = movieDomain.popularity,
            posterPath = movieDomain.posterPath,
            voteAverage = movieDomain.voteAverage,
            voteCount = movieDomain.voteCount,
            video = movieDomain.video,
            title = movieDomain.title,
            adult = movieDomain.adult,
            originalTitle = movieDomain.originalTitle,
            releaseDate = movieDomain.releaseDate,
        )
    }
}

fun List<MovieUi>.isUnknown(): Boolean {
    MovieUi(
        backdropPath = "error",
       // firstAirDate = "error",
        genreIds = listOf(1),
        id = -1,
    //    name = "error",
      //  originCountry = listOf("error"),
        originalLanguage = "error",
        overview = "error",
        popularity = 0.0,
        posterPath = "error",
        voteAverage = 0.0,
        voteCount = -1,
        video = false,
        title = "error",
        adult = false,
        originalTitle = "error",
        releaseDate = "error"
    )
    return this.isEmpty()
}