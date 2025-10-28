package org.ghibli_wiki.controllers

import Vehicle
import org.ghibli_wiki.services.GhibliService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class VehiclesController(val ghibliService: GhibliService) {

    @GetMapping("/vehicles/{id}")
    suspend fun getVehicleById(@PathVariable(required = true) id: String): Vehicle {
        return ghibliService.getVehicleById(id)
    }

    @GetMapping("/vehicles")
    suspend fun getVehicles(): List<Vehicle> {
        return ghibliService.getVehicles()
    }
}