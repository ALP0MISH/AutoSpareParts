package com.example.autospareparts.domain.models

data class MovieDomain(
    val backdropPath: String,
    val id: Int,
    val posterPath: String?,
    val title: String,
    val voteAverage: Double,
    val releaseDate: String
){
    companion object{
        val preview = MovieDomain(
            backdropPath = "",
            id = 0,
            posterPath = "",
            title = "",
            voteAverage = 0.0,
            releaseDate = ""
        )
    }
}