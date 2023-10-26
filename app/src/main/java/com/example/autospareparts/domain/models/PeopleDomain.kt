package com.example.autospareparts.domain.models

data class PeopleDomain(
    val cast_id: Int,
    val credit_id: String,
    val id: Int,
    val name: String,
    val original_name: String?,
    val popularity: Double?,
    val profile_path: String?
)