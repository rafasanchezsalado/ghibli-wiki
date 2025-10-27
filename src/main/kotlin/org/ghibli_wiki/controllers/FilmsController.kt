package org.ghibli_wiki.controllers

import Film
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FilmsController {
    var films = arrayOf(Film("123"), Film("456"))

    @GetMapping("/films/{id}")
    fun getFilmById(@PathVariable(required = true) id: Int): Film {
        return films[id]
    }

    @GetMapping("/films")
    fun getAllFilms(): Array<Film> {
        return films
    }
}