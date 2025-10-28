package org.ghibli_wiki.services

import Film
import Location
import People
import Species
import Vehicle
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class GhibliService(@param:Value("\${app.services.ghibli.base_url}") private val baseUrl: String) {

    val filmsUrl: String = "/films"
    val locationUrl: String = "/locations"
    val peopleUrl: String = "/people"
    val speciesUrl: String = "/species"
    val vehicleUrl: String = "/vehicle"

    fun buildWebClient(): WebClient {
        return WebClient.builder().baseUrl(baseUrl).build()
    }

    suspend fun <T> retrieveData(modelUrl: String, modelClass: Class<T>): List<T> {
        return buildWebClient().get().uri(modelUrl).retrieve()
            .bodyToFlux(modelClass).collectList().awaitSingle()
    }

    suspend fun getFilms(): List<Film> {
        return this.retrieveData(filmsUrl, Film::class.java)
    }

    suspend fun getLocations(): List<Location> {
        return this.retrieveData(locationUrl, Location::class.java)
    }

    suspend fun getPeople(): List<People> {
        return this.retrieveData(peopleUrl, People::class.java)
    }

    suspend fun getSpecies(): List<Species> {
        return this.retrieveData(speciesUrl, Species::class.java)
    }

    suspend fun getVehicles(): List<Vehicle> {
        return this.retrieveData(vehicleUrl, Vehicle::class.java)
    }

}