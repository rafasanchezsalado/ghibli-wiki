package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Species
import org.ghibli_wiki.services.SpeciesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SpeciesController(val speciesService: SpeciesService) {

    @GetMapping("/species/{id}")
    suspend fun getSpeciesById(@PathVariable(required = true) id: String): Species {
        return speciesService.getSpeciesById(id)
    }

    @GetMapping("/species")
    suspend fun getSpecies(): List<Species> {
        return speciesService.getSpecies()
    }
}