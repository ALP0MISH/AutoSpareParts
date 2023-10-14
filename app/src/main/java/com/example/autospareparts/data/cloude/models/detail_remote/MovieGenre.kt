package com.example.autospareparts.data.cloude.models.detail_remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieGenre(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
) : Parcelable