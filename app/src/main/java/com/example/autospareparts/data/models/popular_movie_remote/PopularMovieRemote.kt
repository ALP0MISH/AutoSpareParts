package com.example.autospareparts.data.models.popular_movie_remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularMovieRemote(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieCloud>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
) : Parcelable