package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Film
import org.ghibli_wiki.services.FilmService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FilmsController(val service: FilmService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/films/{id}")
    suspend fun getFilmById(@PathVariable(required = true) id: String): Film {
        loggerUtility.logInfo("Request to '/films/$id'")
        return service.getFilmById(id)
    }

    @GetMapping("/films")
    suspend fun getFilms(@RequestParam(required = false) params: Map<String, String>): List<Film> {
        return if (params.isEmpty()) {
            loggerUtility.logInfo("Request to '/films'")
            service.getFilms()
        } else {
            loggerUtility.logInfo("params:$params")
            val field = params.entries.first().key
            val value = params.entries.first().value
            loggerUtility.logInfo("Request to '/films?$field=$value'")
            service.filterFilms(field, value)
        }
    }
}