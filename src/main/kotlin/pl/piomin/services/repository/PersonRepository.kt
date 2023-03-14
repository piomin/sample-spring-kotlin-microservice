package pl.piomin.services.repository

import jakarta.annotation.PostConstruct
import net.datafaker.Faker
import org.springframework.stereotype.Repository
import pl.piomin.services.model.Gender
import pl.piomin.services.model.Person
import java.util.*


@Repository
class PersonRepository {
    val persons = mutableListOf<Person>()

    @PostConstruct
    fun init() {
        val faker = Faker()
        for (i in 0..999) {
            val name = faker.name().fullName()
            val gender = faker.gender().binaryTypes().uppercase(Locale.ENGLISH)
            val age = faker.number().numberBetween(18, 85)
            persons.add(Person(i + 1, name, age, Gender.valueOf(gender)))
        }
    }

    fun findById(id: Int): Person? = persons.singleOrNull { it.id == id }

    fun findByAge(age: Int): List<Person> = persons.filter { it.age == age }

    fun findAll(): List<Person> = persons

    fun save(person: Person): Person {
        person.id = (persons.maxByOrNull { it.id!! }?.id ?: 0) + 1
        persons.add(person)
        return person
    }

    fun update(person: Person): Person {
        val index = persons.indexOfFirst { it.id == person.id }
        if (index >= 0) {
            persons[index] = person
        }
        return person
    }

    fun removeById(id: Int): Boolean = persons.removeIf { it.id == id }

}
