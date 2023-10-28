package com.example.moviesapp.domain.models

import java.time.LocalDateTime
import java.util.UUID

data class ReviewsDomain(
    val author: String,
    val reviewsDetails: ReviewsDetailDomain,
    val content: String,
    val id: String,
    val created_at:LocalDateTime
) {
    companion object {
        val unknown = ReviewsDomain(
            author = "Abdurahan",
            content = "ffsfsd",
            id = UUID.randomUUID().toString(),
            reviewsDetails = ReviewsDetailDomain.unknown,
            created_at = LocalDateTime.now()
        )
    }
}