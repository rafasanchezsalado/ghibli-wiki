package org.ghibli_wiki.controllers

import Location
import org.ghibli_wiki.services.GhibliService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationsController(val ghibliService: GhibliService) {

    @GetMapping("/locations/{id}")
    suspend fun getLocationById(@PathVariable(required = true) id: String): Location {
        return ghibliService.getLocationById(id)
    }

    @GetMapping("/locations")
    suspend fun getLocations(): List<Location> {
        return ghibliService.getLocations()
    }
}