package org.ghibli_wiki.controllers

import Location
import org.ghibli_wiki.services.GhibliService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationsController(val ghibliService: GhibliService) {

    @GetMapping("/locations/{id}")
    suspend fun getLocationById(@PathVariable(required = true) id: Int): Location {
        return ghibliService.getLocations()[0]
    }

    @GetMapping("/locations")
    suspend fun getAllLocations(): List<Location> {
        return ghibliService.getLocations()
    }
}