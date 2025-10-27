package org.ghibli_wiki.controllers

import Location
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationsController {
    var locations = arrayOf(Location("123"), Location("456"))

    @GetMapping("/locations/{id}")
    fun getLocationById(@PathVariable(required = true) id: Int): Location {
        return locations[id]
    }

    @GetMapping("/locations")
    fun getAllLocations(): Array<Location> {
        return locations
    }
}