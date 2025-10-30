package org.ghibli_wiki.controllers

import org.ghibli_wiki.models.Vehicle
import org.ghibli_wiki.services.VehiclesService
import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class VehiclesController(val service: VehiclesService) {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/vehicles/{id}")
    suspend fun getVehicleById(@PathVariable(required = true) id: String): Vehicle {
        loggerUtility.logInfo("Request to '/vehicles/$id'")
        return service.getVehicleById(id)
    }

    @GetMapping("/vehicles")
    suspend fun getVehicles(@RequestParam(required = false) params: Map<String, String>): List<Vehicle> {
        return if (params.isEmpty()) {
            loggerUtility.logInfo("Request to '/vehicles'")
            service.getVehicles()
        } else {
            loggerUtility.logInfo("params:$params")
            val field = params.entries.first().key
            val value = params.entries.first().value
            loggerUtility.logInfo("Request to '/vehicles?$field=$value'")
            service.filterVehicles(field, value)
        }
    }

}