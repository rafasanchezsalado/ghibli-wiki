package org.ghibli_wiki.models

import com.fasterxml.jackson.annotation.JsonProperty

data class People(
    val id: String,
    val name: String,
    val gender: String,
    val age: String,
    @JsonProperty("eye_color") val eyeColor: String,
    @JsonProperty("hair_color") val hairColor: String,
    val films: List<String>,
    val species: String,
    val url: String
)