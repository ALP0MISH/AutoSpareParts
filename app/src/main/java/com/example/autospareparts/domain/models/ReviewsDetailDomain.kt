package com.example.autospareparts.domain.models

data class ReviewsDetailDomain(
    val avatar_path: String,
    val name: String,
    val rating: Double,
    val username: String
){
    companion object{
        val unknown = ReviewsDetailDomain(
            avatar_path = String(),
            name = "",
            rating = 1.0,
            username = "vdvdvdb"
        )
    }
}