package org.ghibli_wiki.models

data class Location(
    val id: String,
    val name: String,
    val climate: String,
    val terrain: String,
    val surfaceWater: String
)