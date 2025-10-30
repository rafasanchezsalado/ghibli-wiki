package org.ghibli_wiki.services

import org.ghibli_wiki.models.Location
import org.springframework.stereotype.Service

@Service
class LocationService(private val service: BaseService) {

    val locationsUrl: String = "/locations"

    suspend fun getLocationById(id: String): Location {
        return service.retrieveData("$locationsUrl/$id", Location::class.java)[0]
    }

    suspend fun getLocations(): List<Location> {
        return service.retrieveData(locationsUrl, Location::class.java)
    }

    suspend fun filterLocations(field: String, value: String): List<Location> {
        val locations = service.retrieveData(locationsUrl, Location::class.java)
        // filter
        val filteredLocations = locations.filter {
            when (field) {
                "name" -> it.name.equals(value, true)
                "climate" -> it.climate.equals(value, true)
                "surfaceWater" -> it.surfaceWater.equals(value, true)
                "terrain" -> it.terrain.equals(value, true)
                else -> false
            }
        }
        return filteredLocations
    }

}