package com.example.autospareparts.domain.models

import com.example.autospareparts.presentation.models.MovieUi

data class MovieDomain(
    val backdropPath: String,
   // val firstAirDate: String,
    val genreIds: List<Int>,
    val id: Int,
  //  val name: String,
   // val originCountry: List<String>,
    val originalLanguage: String,
  //  val originalName: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteCount: Int,
    val voteAverage: Double,
    val releaseDate: String,
    val video: Boolean,
    val title: String,
    val adult: Boolean,
    ){

    companion object{
        val unknown = MovieDomain(
            backdropPath = "error",
       //     firstAirDate = "error",
            genreIds = listOf(1),
            id = -1,
        //    name = "error",
       //     originCountry = listOf("error"),
            originalLanguage = "error",
            overview = "error",
            popularity = 0.0,
            posterPath = "error",
            voteAverage = 0.0,
            voteCount = -1,
            video = false,
            title = "error",
            adult = false,
       //     originalName = "error",
            releaseDate = "error",
            originalTitle = "error"
        )
    }
}
