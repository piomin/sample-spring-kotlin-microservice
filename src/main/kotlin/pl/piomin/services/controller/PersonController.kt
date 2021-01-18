package pl.piomin.services.controller

import org.springframework.web.bind.annotation.*
import pl.piomin.services.model.Person
import pl.piomin.services.repository.PersonRepository

@RestController
@RequestMapping("/persons")
class PersonController(val repository: PersonRepository) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Person? = repository.findById(id)

    @GetMapping
    fun findAll(): List<Person> = repository.findAll()

    @PostMapping
    fun add(@RequestBody person: Person): Person = repository.save(person)

    @PutMapping
    fun update(@RequestBody person: Person): Person = repository.update(person)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int): Boolean = repository.removeById(id)

}
