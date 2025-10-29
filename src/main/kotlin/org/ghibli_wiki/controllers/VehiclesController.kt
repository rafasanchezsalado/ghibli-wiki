package org.ghibli_wiki.controllers

import Vehicle
import org.ghibli_wiki.services.VehiclesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class VehiclesController(val vehiclesService: VehiclesService) {

    @GetMapping("/vehicles/{id}")
    suspend fun getVehicleById(@PathVariable(required = true) id: String): Vehicle {
        return vehiclesService.getVehicleById(id)
    }

    @GetMapping("/vehicles")
    suspend fun getVehicles(): List<Vehicle> {
        return vehiclesService.getVehicles()
    }
}