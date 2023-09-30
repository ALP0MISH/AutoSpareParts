package com.example.autospareparts.presentation.models

data class MovieUi(
    val backdropPath: String,
   // val firstAirDate: String,
    val genreIds: List<Int>,
    val id: Int,
  //  val name: String,
  //  val originCountry: List<String>,
    val originalLanguage: String,
   // val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val voteAverage: Double,
    val voteCount: Int,
    val video: Boolean,
    val title: String,
    val adult: Boolean,
    val releaseDate: String,
    val originalTitle: String,

    ){

    fun isUnknown() = this == unknown

    companion object{
        val unknown = MovieUi(
            backdropPath = "error",
         //   firstAirDate = "error",
            genreIds = listOf(1),
            id = -1,
       //     name = "error",
           // originCountry = listOf("error"),
            originalLanguage = "error",
            overview = "error",
            popularity = 0.0,
            posterPath = "error",
            voteAverage = 0.0,
            voteCount = -1,
            video = false,
            title = "error",
            adult = false,
            releaseDate = "error",
            originalTitle = "error"
      //      originalName = "error"
        )
    }

}
