package pl.piomin.services.repository

import org.springframework.stereotype.Repository
import pl.piomin.services.model.Gender
import pl.piomin.services.model.Person
import javax.annotation.PostConstruct

@Repository
class PersonRepository {
    val persons = mutableListOf<Person>()

    @PostConstruct
    fun init() {
        save(Person(null, "John Smith", 39, Gender.MALE))
        save(Person(null, "Paul Walker", 48, Gender.MALE))
        save(Person(null, "Kate Morgan", 21, Gender.FEMALE))
    }

    fun findById(id: Int): Person? = persons.singleOrNull { it.id == id }

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
