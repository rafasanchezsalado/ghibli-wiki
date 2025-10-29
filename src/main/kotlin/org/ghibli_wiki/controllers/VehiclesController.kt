package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Vehicle
import org.ghibli_wiki.services.VehiclesService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class VehiclesController(val vehiclesService: VehiclesService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/vehicles/{id}")
    suspend fun getVehicleById(@PathVariable(required = true) id: String): Vehicle {
        loggerUtility.logInfo("Request to '/vehicles/$id'")
        return vehiclesService.getVehicleById(id)
    }

    @GetMapping("/vehicles")
    suspend fun getVehicles(): List<Vehicle> {
        loggerUtility.logInfo("Request to '/vehicles'")
        return vehiclesService.getVehicles()
    }
}