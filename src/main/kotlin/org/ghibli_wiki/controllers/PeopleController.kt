package org.ghibli_wiki.controllers

import People
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PeopleController {
    var people = arrayOf(People("123"), People("456"))

    @GetMapping("/people/{id}")
    fun getPeopleById(@PathVariable(required = true) id: Int): People {
        return people[id]
    }

    @GetMapping("/people")
    fun getAllPeople(): Array<People> {
        return people
    }
}