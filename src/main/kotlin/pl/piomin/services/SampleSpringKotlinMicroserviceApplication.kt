package pl.piomin.services

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleSpringKotlinMicroserviceApplication

fun main(args: Array<String>) {
    runApplication<SampleSpringKotlinMicroserviceApplication>(*args)
}