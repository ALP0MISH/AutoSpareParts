package com.example.moviesapp.data.cloude.models.all_movies_remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieRemote(
    @SerializedName("results")
    val results: List<MovieResult>,
): Parcelable