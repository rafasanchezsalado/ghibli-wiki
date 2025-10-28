package org.ghibli_wiki

import org.ghibli_wiki.utilities.LoggerUtility
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController() {

    private val loggerUtility: LoggerUtility = LoggerUtility()

    @GetMapping("/")
    fun home(): String {
        loggerUtility.logInfo("Request to '/'")
        return "Hello World"
    }
}