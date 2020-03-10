package pl.piomin.services.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/properties")
class TestPropertyController(@Value("\${property1}") val property1: String) {

    @GetMapping
    fun printProperty1(): String  = property1

}