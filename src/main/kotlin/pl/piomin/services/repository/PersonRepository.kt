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
        save(Person(null, "John Smith", 33, Gender.MALE))
        save(Person(null, "Paul Walker", 44, Gender.MALE))
        save(Person(null, "Kate Morgan", 22, Gender.FEMALE))
    }

    fun findById(id: Int): Person? {
        return persons.singleOrNull { it.id == id }
    }

    fun findAll(): List<Person> {
        return persons
    }

    fun save(person: Person): Person {
        person.id = (persons.maxBy { it.id!! }?.id ?: 0) + 1
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

    fun removeById(id: Int): Boolean {
        return persons.removeIf { it.id == id }
    }

}
