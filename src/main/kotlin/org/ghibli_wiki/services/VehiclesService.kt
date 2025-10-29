package org.ghibli_wiki.services

import org.ghibli_wiki.models.Vehicle
import org.springframework.stereotype.Service

@Service
class VehiclesService(private val service: BaseService) {

    val vehicleUrl: String = "/vehicle"

    suspend fun getVehicleById(id: String): Vehicle {
        return service.retrieveData("$vehicleUrl/$id", Vehicle::class.java)[0]
    }

    suspend fun getVehicles(): List<Vehicle> {
        return service.retrieveData(vehicleUrl, Vehicle::class.java)
    }

}