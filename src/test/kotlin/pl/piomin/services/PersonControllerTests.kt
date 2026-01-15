package pl.piomin.services

import org.instancio.Instancio
import org.instancio.Select
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.servlet.client.RestTestClient
import org.springframework.test.web.servlet.client.expectBody
import pl.piomin.services.model.Person

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@AutoConfigureRestTestClient
class PersonControllerTests {

    @Autowired
    lateinit var client: RestTestClient

    @Test
    @Order(1)
    fun shouldAddPerson() {
        val person = Instancio.of(Person::class.java)
            .ignore(Select.field("id"))
            .create()
        val savedPerson = client.post().uri("/persons")
            .body(person)
            .exchange()
            .expectStatus().isOk
            .expectBody(Person::class.java)
            .returnResult().responseBody

        Assertions.assertNotNull(savedPerson)
        Assertions.assertNotNull(savedPerson?.id)
        Assertions.assertEquals(1001, savedPerson?.id)
    }

    @Test
    @Order(2)
    fun shouldUpdatePerson() {
        val person = Instancio.of(Person::class.java)
            .set(Select.field("id"), 1)
            .create()
        client.put().uri("/persons")
            .body(person)
            .exchange()
            .expectStatus().isOk

        val personRemote = client.get().uri("/persons/{id}", 1)
            .exchange()
            .expectStatus().isOk
            .expectBody<Person>()
            .returnResult().responseBody

        Assertions.assertNotNull(personRemote)
        Assertions.assertEquals(person.age, personRemote?.age)
    }

    @Test
    @Order(3)
    fun shouldDeletePerson() {
        client.delete().uri("/persons/{id}", 1)
            .exchange()
            .expectStatus().isOk

        val personRemote = client.get().uri("/persons/{id}", 1)
            .exchange()
            .expectStatus().isOk
            .expectBody<Person>()
            .returnResult().responseBody
        Assertions.assertNull(personRemote)
    }

}