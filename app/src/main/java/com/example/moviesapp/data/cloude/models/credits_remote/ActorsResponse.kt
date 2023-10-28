package com.example.moviesapp.data.cloude.models.credits_remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActorsResponse(
    @SerializedName("cast")
    val poepleCloude: List<PoepleCloude>,
    @SerializedName("crew")
    val crewCloud: List<PoepleCloude>,
    @SerializedName("id")
    val id: Int
) : Parcelable {
    companion object {
        val unknown = ActorsResponse(
            poepleCloude = emptyList(),
            crewCloud = emptyList(),
            id = -1
        )
    }
}