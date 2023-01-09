package pl.piomin.services.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/envs")
class EnvsController {

    @Value("\${PASS:#{null}}")
    lateinit var password: String

    @GetMapping
    fun info(): String = password
}