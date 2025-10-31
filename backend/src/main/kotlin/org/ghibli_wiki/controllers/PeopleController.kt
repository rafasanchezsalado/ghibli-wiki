package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.People
import org.ghibli_wiki.services.PeopleService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PeopleController(val service: PeopleService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/people/{id}")
    suspend fun getPeopleById(@PathVariable(required = true) id: String): People {
        loggerUtility.logInfo("Request to '/people/$id'")
        return service.getPeopleById(id)
    }

    @GetMapping("/people")
    suspend fun getPeople(@RequestParam(required = false) params: Map<String, String>): List<People> {
        loggerUtility.logInfo("Request to '/people'")
        return if (params.isEmpty()) {
            service.getPeople()
        } else {
            loggerUtility.logInfo("filter params:$params")
            service.filterPeople(params)
        }
    }

}