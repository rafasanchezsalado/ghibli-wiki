package org.ghibli_wiki

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    @GetMapping("/")
    fun home(): String {
        return "Hello World"
    }
}