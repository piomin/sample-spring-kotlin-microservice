package pl.piomin.services.repository

import org.springframework.stereotype.Repository
import pl.piomin.services.model.Person

@Repository
class PersonRepository {
    val persons: MutableList<Person> = ArrayList()

    fun findById(id: Int): Person? {
        return persons.singleOrNull { it.id == id }
    }

    fun findAll(): List<Person> {
        return persons
    }

    fun save(person: Person): Person {
        person.id = persons.size + 1
        persons.add(person)
        return person
    }

    fun update(person: Person): Person {
        val index = persons.indexOf(person)
        persons[index] = person
        return person
    }

    fun removeById(id: Int): Boolean {
        return persons.removeIf { it.id == id }
    }

}