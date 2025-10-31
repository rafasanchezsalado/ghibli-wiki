package org.ghibli_wiki.services

import org.ghibli_wiki.models.Film
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

    suspend fun filterFilms(params: Map<String, String>): List<Film> {
        var filteredFilms: List<Film> = getFilms() // all results first, no filters
        for (param in params) {
            val field = param.key
            val value = param.value
            filteredFilms = filteredFilms.filter {
                when (field) {
                    "description" -> it.description.equals(value, true)
                    "director" -> it.director.equals(value, true)
                    "originalTitle" -> it.originalTitle.equals(value, true)
                    "originalTitleRomanised" -> it.originalTitleRomanised.equals(value, true)
                    "producer" -> it.producer.equals(value, true)
                    "releaseDate" -> it.releaseDate.equals(value, true)
                    "rtScore" -> it.rtScore.equals(value, true)
                    "runningTime" -> it.runningTime.equals(value, true)
                    "title" -> it.title.equals(value, true)
                    else -> false
                }
            }
        }
        return filteredFilms
    }
}