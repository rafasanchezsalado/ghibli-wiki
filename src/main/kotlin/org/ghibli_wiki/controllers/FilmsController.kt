package org.ghibli_wiki.controllers

import Film
import org.ghibli_wiki.services.GhibliService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FilmsController(val ghibliService: GhibliService) {

    @GetMapping("/films/{id}")
    suspend fun getFilmById(@PathVariable(required = true) id: Int): Film {
        return ghibliService.getFilms()[0]
    }

    @GetMapping("/films")
    suspend fun getAllFilms(): List<Film> {
        return ghibliService.getFilms()
    }
}