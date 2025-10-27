package org.ghibli_wiki.controllers

import Species
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SpeciesController {
    var species = arrayOf(Species("123"), Species("456"))

    @GetMapping("/species/{id}")
    fun getSpeciesById(@PathVariable(required = true) id: Int): Species {
        return species[id]
    }

    @GetMapping("/species")
    fun getAllSpecies(): Array<Species> {
        return species
    }
}