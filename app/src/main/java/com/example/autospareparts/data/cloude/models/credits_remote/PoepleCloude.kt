package com.example.autospareparts.data.cloude.models.credits_remote

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PoepleCloude(
    @SerializedName("cast_id")
    val cast_id: Int,
    @SerializedName("credit_id")
    val credit_id: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_name")
    val original_name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profile_path: String?
) : Parcelable