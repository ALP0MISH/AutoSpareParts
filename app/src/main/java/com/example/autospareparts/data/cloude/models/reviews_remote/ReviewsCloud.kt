package com.example.autospareparts.data.cloude.models.reviews_remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReviewsCloud(
    @SerializedName("author")
    val author: String,
    @SerializedName("author_details")
    val reviewsDetailCloud: ReviewsDetailCloud,
    @SerializedName("content")
    val content: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("created_at")
    val created_at : String
): Parcelable