package org.ghibli_wiki.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Film(
    val id: String,
    val title: String,
    @JsonProperty("original_title") val originalTitle: String,
    @JsonProperty("original_title_romanised") val originalTitleRomanised: String,
    val description: String,
    val director: String,
    val producer: String,
    @JsonProperty("release_date") val releaseDate: String,
    @JsonProperty("running_time") val runningTime: String,
    @JsonProperty("rt_score") val rtScore: String,
    val people: List<String>,
    val species: List<String>,
    val locations: List<String>,
    val vehicles: List<String>,
    val url: String
)