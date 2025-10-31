package org.ghibli_wiki.services

import org.ghibli_wiki.models.Vehicle
import org.springframework.stereotype.Service

@Service
class VehiclesService(private val service: BaseService) {

    val vehiclesUrl: String = "/vehicles"

    suspend fun getVehicleById(id: String): Vehicle {
        return service.retrieveData("$vehiclesUrl/$id", Vehicle::class.java)[0]
    }

    suspend fun getVehicles(): List<Vehicle> {
        return service.retrieveData(vehiclesUrl, Vehicle::class.java)
    }

    suspend fun filterVehicles(params: Map<String, String>): List<Vehicle> {
        var filteredVehicles: List<Vehicle> = getVehicles() // all results first, no filters
        for (param in params) {
            val field = param.key
            val value = param.value
            filteredVehicles = filteredVehicles.filter {
                when (field) {
                    "classification" -> it.description.equals(value, true)
                    "length" -> it.length.equals(value, true)
                    "name" -> it.name.equals(value, true)
                    // "pilot" -> it.pilot.equals(value, true)
                    "vehicleClass" -> it.vehicleClass.equals(value, true)
                    else -> false
                }
            }
        }
        return filteredVehicles
    }

}