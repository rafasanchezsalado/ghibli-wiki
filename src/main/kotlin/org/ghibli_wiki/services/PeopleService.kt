package org.ghibli_wiki.services

import org.ghibli_wiki.models.People
import org.springframework.stereotype.Service

@Service
class PeopleService(private val service: BaseService) {

    val peopleUrl: String = "/people"

    suspend fun getPeopleById(id: String): People {
        return service.retrieveData("$peopleUrl/$id", People::class.java)[0]
    }

    suspend fun getPeople(): List<People> {
        return service.retrieveData(peopleUrl, People::class.java)
    }

}