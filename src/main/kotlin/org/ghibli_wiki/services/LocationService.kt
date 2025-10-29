package org.ghibli_wiki.services

import org.ghibli_wiki.models.Location
import org.springframework.stereotype.Service

@Service
class LocationService(private val service: BaseService) {

    val locationUrl: String = "/locations"

    suspend fun getLocationById(id: String): Location {
        return service.retrieveData("$locationUrl/$id", Location::class.java)[0]
    }

    suspend fun getLocations(): List<Location> {
        return service.retrieveData(locationUrl, Location::class.java)
    }

}