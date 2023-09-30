package com.example.autospareparts.data.models.top_rated_movie_remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopRatedMovieRemote(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TopRatedResultX>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
): Parcelable