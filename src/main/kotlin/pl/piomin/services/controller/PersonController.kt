package pl.piomin.services.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import pl.piomin.services.model.Person
import pl.piomin.services.repository.PersonRepository
import java.util.concurrent.atomic.AtomicInteger

@RestController
@RequestMapping("/persons")
class PersonController(val repository: PersonRepository) {

    val log: Logger = LoggerFactory.getLogger(PersonController::class.java)
    val num: AtomicInteger = AtomicInteger()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Person? {
        log.info("({}) findById({})", num.incrementAndGet(), id)
        return repository.findById(id)
    }

    @GetMapping("/ages/{age}")
    fun findByAge(@PathVariable age: Int): List<Person> {
        log.info("({}) findByAge({})", num.incrementAndGet(), age)
        return repository.findByAge(age)
    }

    @GetMapping
    fun findAll(): List<Person> {
        log.info("({}) findAll()", num.incrementAndGet())
        return repository.findAll()
    }

    @PostMapping
    fun add(@RequestBody person: Person): Person = repository.save(person)

    @PutMapping
    fun update(@RequestBody person: Person): Person = repository.update(person)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int): Boolean = repository.removeById(id)

}
