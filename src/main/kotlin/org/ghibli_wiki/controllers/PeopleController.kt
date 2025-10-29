package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.People
import org.ghibli_wiki.services.PeopleService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PeopleController(val peopleService: PeopleService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/people/{id}")
    suspend fun getPeopleById(@PathVariable(required = true) id: String): People {
        loggerUtility.logInfo("Request to '/people/$id'")
        return peopleService.getPeopleById(id)
    }

    @GetMapping("/people")
    suspend fun getPeople(): List<People> {
        loggerUtility.logInfo("Request to '/people'")
        return peopleService.getPeople()
    }
}