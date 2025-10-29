package org.ghibli_wiki.controllers

import Location
import org.ghibli_wiki.services.LocationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationsController(val locationService: LocationService) {

    @GetMapping("/locations/{id}")
    suspend fun getLocationById(@PathVariable(required = true) id: String): Location {
        return locationService.getLocationById(id)
    }

    @GetMapping("/locations")
    suspend fun getLocations(): List<Location> {
        return locationService.getLocations()
    }
}