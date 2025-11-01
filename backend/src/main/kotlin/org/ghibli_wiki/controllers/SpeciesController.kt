package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Species
import org.ghibli_wiki.services.SpeciesService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:5173"])
@RestController
class SpeciesController(val service: SpeciesService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/species/{id}")
    suspend fun getSpeciesById(@PathVariable(required = true) id: String): Species {
        loggerUtility.logInfo("Request to '/species/$id'")
        return service.getSpeciesById(id)
    }

    @GetMapping("/species")
    suspend fun getSpecies(@RequestParam(required = false) params: Map<String, String>): List<Species> {
        loggerUtility.logInfo("Request to '/species'")
        return if (params.isEmpty()) {
            service.getSpecies()
        } else {
            loggerUtility.logInfo("Filter params:$params")
            service.filterSpecies(params)
        }
    }

}