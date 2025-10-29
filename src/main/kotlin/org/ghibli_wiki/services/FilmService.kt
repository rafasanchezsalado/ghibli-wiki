package org.ghibli_wiki.services

import Film
import org.springframework.stereotype.Service

@Service
class FilmService(private val service: BaseService) {

    val filmsUrl: String = "/films"

    suspend fun getFilmById(id: String): Film {
        return service.retrieveData("$filmsUrl/$id", Film::class.java)[0]
    }

    suspend fun getFilms(): List<Film> {
        return service.retrieveData(filmsUrl, Film::class.java)
    }

}