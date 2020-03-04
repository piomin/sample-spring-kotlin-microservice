package pl.piomin.services.controller

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.async.DeferredResult
import pl.piomin.services.model.Person
import pl.piomin.services.repository.PersonRepository
import java.util.concurrent.Callable

@RestController
@RequestMapping("/persons")
class PersonController(var repository: PersonRepository) {

    val logger : Logger = LoggerFactory.getLogger(PersonController::class.java)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Person? = repository.findById(id)

    @GetMapping
    fun findAll(): List<Person> = repository.findAll()

    @PostMapping
    fun add(@RequestBody person: Person): Person = repository.save(person)

    @PostMapping("/long-running")
    fun addLongRunning(@RequestBody person: Person): DeferredResult<Person> {
        var result: DeferredResult<Person>  = DeferredResult()
        GlobalScope.launch {
            logger.info("Person long-running: {}", person)
            delay(10000L)
            result.setResult(repository.save(person))
        }
        return result
    }

    @PutMapping
    fun update(@RequestBody person: Person): Person = repository.update(person)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int): Boolean = repository.removeById(id)

}
