package org.ghibli_wiki.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Location(
    val id: String,
    val name: String,
    val climate: String,
    val terrain: String,
    @param:JsonProperty("surface_water") val surfaceWater: String,
    val residents: List<String>,
    val films: List<String>,
    val url: String
)