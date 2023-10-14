package com.example.autospareparts.data.cashe.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "movie_table"
)
data class MovieDetailCache(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("adult") val adult: Boolean,
    @ColumnInfo("backdrop_path") val backdropPath: String,
    @ColumnInfo("budget") val budget: Int,
    @ColumnInfo("genres") val movieGenresName: List<String>,
    @ColumnInfo("homepage") val homepage: String,
    @ColumnInfo("original_language") val originalLanguage: String,
    @ColumnInfo("original_title") val originalTitle: String,
    @ColumnInfo("overview") val overview: String,
    @ColumnInfo("popularity") val popularity: Double,
    @ColumnInfo("poster_path") val posterPath: String,
    @ColumnInfo("release_date") val releaseDate: String,
    @ColumnInfo("runtime") val runtime: Int,
    @ColumnInfo("vote_average") val voteAverage: Double,
    @ColumnInfo("vote_count") val voteCount: Int
)