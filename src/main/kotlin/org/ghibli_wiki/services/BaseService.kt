package org.ghibli_wiki.services

import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class BaseService(@param:Value("\${app.services.ghibli.base_url}") private val baseUrl: String) {

    fun buildWebClient(): WebClient {
        return WebClient.builder().baseUrl(baseUrl).build()
    }

    suspend fun <T> retrieveData(modelUrl: String, modelClass: Class<T>): List<T> {
        return buildWebClient().get().uri(modelUrl).retrieve()
            .bodyToFlux(modelClass).collectList().awaitSingle()
    }

}