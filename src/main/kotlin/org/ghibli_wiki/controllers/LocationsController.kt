package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Location
import org.ghibli_wiki.services.LocationService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationsController(val locationService: LocationService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/locations/{id}")
    suspend fun getLocationById(@PathVariable(required = true) id: String): Location {
        loggerUtility.logInfo("Request to '/locations/$id'")
        return locationService.getLocationById(id)
    }

    @GetMapping("/locations")
    suspend fun getLocations(): List<Location> {
        loggerUtility.logInfo("Request to '/locations'")
        return locationService.getLocations()
    }
}