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

    suspend fun filterPeople(params: Map<String, String>): List<People> {
        var filteredPeople: List<People> = getPeople() // all results first, no filters
        for (param in params) {
            val field = param.key
            val value = param.value
            filteredPeople = filteredPeople.filter {
                when (field) {
                    "age" -> it.age.equals(value, true)
                    "eyeColor" -> it.eyeColor.equals(value, true)
                    "gender" -> it.gender.equals(value, true)
                    "hairColor" -> it.hairColor.equals(value, true)
                    "name" -> it.name.equals(value, true)
                    "species" -> it.species.equals(value, true)
                    else -> false
                }
            }
        }
        return filteredPeople
    }

}