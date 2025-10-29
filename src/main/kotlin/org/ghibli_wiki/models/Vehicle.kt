package org.ghibli_wiki.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Vehicle(
    val id: String,
    val name: String,
    val description: String,
    @JsonProperty("vehicle_class") val vehicleClass: String,
    val length: String,
    val pilot: String,
    val films: List<String>,
    val url: String
)