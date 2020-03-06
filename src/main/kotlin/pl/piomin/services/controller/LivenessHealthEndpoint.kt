package pl.piomin.services.controller

import org.springframework.boot.actuate.endpoint.annotation.*
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component

@Component
@Endpoint(id = "liveness")
class LivenessHealthEndpoint {

    @ReadOperation
    fun health() : Health = Health.up().build()

    @ReadOperation
    fun name(@Selector name: String) : String = "liveness"

    @WriteOperation
    fun write(@Selector name: String) {

    }

    @DeleteOperation
    fun delete(@Selector name: String) {

    }

}