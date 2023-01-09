package pl.piomin.services

import org.instancio.Instancio
import org.instancio.Select
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import pl.piomin.services.model.Person

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class PersonControllerTests {

    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    @Order(1)
    fun shouldAddPerson() {
        var person = Instancio.of(Person::class.java)
            .ignore(Select.field("id"))
            .create()
        person = template.postForObject("/persons", person, Person::class.java)
        Assertions.assertNotNull(person)
        Assertions.assertNotNull(person.id)
        Assertions.assertEquals(1001, person.id)
    }

    @Test
    @Order(2)
    fun shouldUpdatePerson() {
        var person = Instancio.of(Person::class.java)
            .set(Select.field("id"), 1)
            .create()
        template.put("/persons", person)
        var personRemote = template.getForObject("/persons/{id}", Person::class.java, 1)
        Assertions.assertNotNull(personRemote)
        Assertions.assertEquals(person.age, personRemote.age)
    }

    @Test
    @Order(3)
    fun shouldDeletePerson() {
        template.delete("/persons/{id}", 1)
        val person = template.getForObject("/persons/{id}", Person::class.java, 1)
        Assertions.assertNull(person)
    }

}