package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Location
import org.ghibli_wiki.services.LocationService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:5173"])
@RestController
class LocationsController(val service: LocationService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/locations/{id}")
    suspend fun getLocationById(@PathVariable(required = true) id: String): Location {
        loggerUtility.logInfo("Request to '/locations/$id'")
        return service.getLocationById(id)
    }

    @GetMapping("/locations")
    suspend fun getLocations(@RequestParam(required = false) params: Map<String, String>): List<Location> {
        loggerUtility.logInfo("Request to '/locations'")
        return if (params.isEmpty()) {
            service.getLocations()
        } else {
            loggerUtility.logInfo("Filter params:$params")
            service.filterLocations(params)
        }
    }
}