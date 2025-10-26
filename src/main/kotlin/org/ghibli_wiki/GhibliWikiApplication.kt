package org.ghibli_wiki

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GhibliWikiApplication

fun main(args: Array<String>) {
	runApplication<GhibliWikiApplication>(*args)
}
