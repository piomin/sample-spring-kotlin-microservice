package pl.piomin.services

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import pl.piomin.services.model.Gender
import pl.piomin.services.model.Person

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class PersonControllerTests {

    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    @Order(1)
    fun shouldAddPerson() {
        var person = Person(null, "Anna Thompson", 20, Gender.FEMALE)
        person = template.postForObject("/persons", person, Person::class.java)
        Assertions.assertNotNull(person)
        Assertions.assertNotNull(person.id)
        Assertions.assertEquals(4, person.id)
    }

    @Test
    @Order(2)
    fun shouldUpdatePerson() {
        var person = Person(1, "John Smith", 21, Gender.MALE)
        template.put("/persons", person)
        person = template.getForObject("/persons/{id}", Person::class.java, 1)
        Assertions.assertNotNull(person)
        Assertions.assertEquals(21, person.age)
    }

    @Test
    @Order(3)
    fun shouldDeletePerson() {
        template.delete("/persons/{id}", 1)
        val person = template.getForObject("/persons/{id}", Person::class.java, 1)
        Assertions.assertNull(person)
    }

}