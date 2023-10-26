package com.example.autospareparts.domain.models

data class ActorsDomain(
    val poepleCloude: List<PeopleDomain>,
    val crewCloud: List<PeopleDomain>,
    val id: Int,
)