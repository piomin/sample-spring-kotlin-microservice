package pl.piomin.services

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleSpringKotlinMicroserviceApplication

fun main(args: Array<String>) {
    runApplication<SampleSpringKotlinMicroserviceApplication>(*args)
}