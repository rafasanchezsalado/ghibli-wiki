package org.ghibli_wiki.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Species(
    val id: String,
    val name: String,
    val classification: String,
    @JsonProperty("eye_colors") val eyeColors: String,
    @JsonProperty("hair_colors") val hairColors: String,
    val url: String,
    val people: List<String>,
    val films: List<String>,
)