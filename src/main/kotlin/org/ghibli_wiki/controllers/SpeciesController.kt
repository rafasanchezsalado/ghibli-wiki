package org.ghibli_wiki.controllers

import Species
import org.ghibli_wiki.services.GhibliService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SpeciesController(val ghibliService: GhibliService) {

    @GetMapping("/species/{id}")
    suspend fun getSpeciesById(@PathVariable(required = true) id: Int): Species {
        return ghibliService.getSpecies()[0]
    }

    @GetMapping("/species")
    suspend fun getAllSpecies(): List<Species> {
        return ghibliService.getSpecies()
    }
}