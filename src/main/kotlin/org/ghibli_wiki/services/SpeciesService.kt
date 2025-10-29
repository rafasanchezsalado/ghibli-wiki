package org.ghibli_wiki.services

import org.ghibli_wiki.models.Species
import org.springframework.stereotype.Service

@Service
class SpeciesService(private val service: BaseService) {

    val speciesUrl: String = "/species"

    suspend fun getSpeciesById(id: String): Species {
        return service.retrieveData("$speciesUrl/$id", Species::class.java)[0]
    }

    suspend fun getSpecies(): List<Species> {
        return service.retrieveData(speciesUrl, Species::class.java)
    }

}