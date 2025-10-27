package org.ghibli_wiki.controllers

import Vehicle
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class VehiclesController {
    var vehicles = arrayOf(Vehicle("123"), Vehicle("456"))

    @GetMapping("/vehicles/{id}")
    fun getVehicleById(@PathVariable(required = true) id: Int): Vehicle {
        return vehicles[id]
    }

    @GetMapping("/vehicles")
    fun getAllVehicles(): Array<Vehicle> {
        return vehicles
    }
}