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

    suspend fun filterSpecies(params: Map<String, String>): List<Species> {
        var filteredSpecies: List<Species> = getSpecies() // all results first, no filters
        for (param in params) {
            val field = param.key
            val value = param.value
            filteredSpecies = filteredSpecies.filter {
                when (field) {
                    "classification" -> it.classification.equals(value, true)
                    "eyeColors" -> it.eyeColors.equals(value, true)
                    "hairColors" -> it.hairColors.equals(value, true)
                    "name" -> it.name.equals(value, true)
                    else -> false
                }
            }
        }
        return filteredSpecies
    }

}