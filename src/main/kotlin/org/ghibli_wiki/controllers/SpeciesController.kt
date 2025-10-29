package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Species
import org.ghibli_wiki.services.SpeciesService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SpeciesController(val speciesService: SpeciesService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/species/{id}")
    suspend fun getSpeciesById(@PathVariable(required = true) id: String): Species {
        loggerUtility.logInfo("Request to '/species/$id'")
        return speciesService.getSpeciesById(id)
    }

    @GetMapping("/species")
    suspend fun getSpecies(): List<Species> {
        loggerUtility.logInfo("Request to '/species'")
        return speciesService.getSpecies()
    }
}