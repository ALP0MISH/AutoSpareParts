package com.example.autospareparts.data.cloude.models.reviews_remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
@Parcelize
data class ReviewsDetailCloud(
    @SerializedName("avatar_path")
    val avatar_path: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("username")
    val username: String
): Parcelable