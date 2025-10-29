package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Film
import org.ghibli_wiki.services.FilmService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FilmsController(val filmService: FilmService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/films/{id}")
    suspend fun getFilmById(@PathVariable(required = true) id: String): Film {
        loggerUtility.logInfo("Request to '/films/$id'")
        return filmService.getFilmById(id)
    }

    @GetMapping("/films")
    suspend fun getFilms(): List<Film> {
        loggerUtility.logInfo("Request to '/films'")
        return filmService.getFilms()
    }
}