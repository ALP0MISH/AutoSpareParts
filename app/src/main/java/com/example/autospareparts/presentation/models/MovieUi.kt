package com.example.autospareparts.presentation.models

data class MovieUi(
    val backdropPath: String,
    val id: Int,
    val posterPath: String?,
    val voteAverage: Double,
    val title: String,
    val releaseDate: String,
    val runtime: Int

    ){
    fun isUnknown() = this == unknown

    companion object{
        val unknown = MovieUi(
            backdropPath = "error",
            id = -1,
            posterPath = "error",
            voteAverage = 0.0,
            title = "",
            releaseDate = "",
            runtime = 0
        )
    }

}
