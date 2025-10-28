package org.ghibli_wiki.controllers

import People
import org.ghibli_wiki.services.GhibliService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PeopleController(val ghibliService: GhibliService) {

    @GetMapping("/people/{id}")
    suspend fun getPeopleById(@PathVariable(required = true) id: String): People {
        return ghibliService.getPeopleById(id)
    }

    @GetMapping("/people")
    suspend fun getPeople(): List<People> {
        return ghibliService.getPeople()
    }
}