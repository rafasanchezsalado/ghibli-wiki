package org.ghibli_wiki.controllers

import Species
import org.ghibli_wiki.services.GhibliService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SpeciesController(val ghibliService: GhibliService) {

    @GetMapping("/species/{id}")
    suspend fun getSpeciesById(@PathVariable(required = true) id: String): Species {
        return ghibliService.getSpeciesById(id)
    }

    @GetMapping("/species")
    suspend fun getSpecies(): List<Species> {
        return ghibliService.getSpecies()
    }
}